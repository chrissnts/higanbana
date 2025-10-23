package com.christian.controllers;
import com.christian.models.Anime;
import com.christian.models.Genre;
import com.christian.models.Studio;
import com.christian.models.User;
import com.christian.repository.interfaces.AnimeRepository;
import io.javalin.http.Context;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnimeController {
    private final AnimeRepository animeRepository;

    public AnimeController(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public void createForm(Context ctx) {
        User currentUser = ctx.sessionAttribute("currentUser");
        Map<String, Object> model = animeRepository.getAnimeModel(currentUser);
        ctx.render("anime/create.ftl", model);
    }

    public void create(Context ctx) {
        Anime anime = new Anime();
        anime.setTitle(ctx.formParam("title"));
        anime.setEpisodesCount(Integer.parseInt(ctx.formParam("episodesCount")));
        anime.setSynopsis(ctx.formParam("synopsis"));
        anime.setImageUrl(ctx.formParam("imageUrl"));
        anime.setReleaseDate(LocalDate.parse(ctx.formParam("releaseDate")));


        Studio studio = new Studio();
        studio.setId(Long.parseLong(ctx.formParam("studioId")));
        anime.setStudio(studio);

        String[] genreIds = ctx.formParams("genreIds").toArray(new String[0]);
        List<Genre> genreList = new ArrayList<>();
        for (String genreId : genreIds) {
            Genre genre = new Genre();
            genre.setId(Long.parseLong(genreId));
            genreList.add(genre);
        }
        anime.setGenres(genreList);

        animeRepository.createAnime(anime);

        ctx.redirect("/dashboard");
    }

    public void editForm(Context ctx) {
        long id = Long.parseLong(ctx.pathParam("id"));
        Anime anime = animeRepository.findById((Long) id); 
        User currentUser = ctx.sessionAttribute("currentUser");

        Map<String, Object> model = animeRepository.getAnimeModel(currentUser);
        model.put("anime", anime);
        ctx.render("anime/edit.ftl", model);
    }

    public void edit(Context ctx) {
        Anime anime = new Anime();
        anime.setId(Long.parseLong(ctx.formParam("id")));
        anime.setTitle(ctx.formParam("title"));
        anime.setEpisodesCount(Integer.parseInt(ctx.formParam("episodesCount")));
        anime.setSynopsis(ctx.formParam("synopsis"));
        anime.setImageUrl(ctx.formParam("imageUrl"));
        anime.setReleaseDate(LocalDate.parse(ctx.formParam("releaseDate")));

        Studio studio = new Studio();
        studio.setId(Long.parseLong(ctx.formParam("studioId")));
        anime.setStudio(studio);

        String[] genreIds = ctx.formParams("genreIds").toArray(new String[0]);
        List<Genre> genreList = new ArrayList<>();
        for (String genreId : genreIds) {
            Genre genre = new Genre();
            genre.setId(Long.parseLong(genreId));
            genreList.add(genre);
        }
        anime.setGenres(genreList);

        animeRepository.updateAnime(anime);

        ctx.redirect("/dashboard");
    }

    public void view(Context ctx) {
        long id = Long.parseLong(ctx.pathParam("id"));
        Anime anime = animeRepository.findById((Long) id); 
        User currentUser = ctx.sessionAttribute("currentUser");
        Map<String, Object> model = animeRepository.getAnimeModel(currentUser);
        model.put("anime", anime);
        ctx.render("anime/view.ftl", model);
    }

    public void delete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        animeRepository.deleteAnime(id);
        ctx.redirect("/dashboard");
    }
}
