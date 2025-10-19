package com.christian.controllers;
import com.christian.models.Anime;
import com.christian.models.User;
import com.christian.repository.interfaces.AnimeRepository;
import io.javalin.http.Context;
import java.time.LocalDate;
import java.util.Map;

public class AnimeController {
    private final AnimeRepository animeRepository;

    public AnimeController(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public void createForm(Context ctx) {
        User currentUser = ctx.sessionAttribute("currentUser");
        Map<String, Object> model = animeRepository.getAnimeModel(currentUser);
        ctx.render("anime-create.ftl", model);
    }

    public void create(Context ctx) {
        Anime anime = new Anime();
        anime.setTitle(ctx.formParam("title"));
        anime.setEpisodesCount(Integer.parseInt(ctx.formParam("episodesCount")));
        anime.setSynopsis(ctx.formParam("synopsis"));
        anime.setImageUrl(ctx.formParam("imageUrl"));
        anime.setReleaseDate(LocalDate.parse(ctx.formParam("releaseDate")));

        animeRepository.createAnime(anime);
        ctx.redirect("/dashboard");
    }

    public void editForm(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Anime anime = animeRepository.findById(id);
        User currentUser = ctx.sessionAttribute("currentUser");

        Map<String, Object> model = animeRepository.getAnimeModel(currentUser);
        model.put("anime", anime);
        ctx.render("anime-edit.ftl", model);
    }

    public void edit(Context ctx) {
        Anime anime = new Anime();
        anime.setId(Long.parseLong(ctx.formParam("id")));
        anime.setTitle(ctx.formParam("title"));
        anime.setEpisodesCount(Integer.parseInt(ctx.formParam("episodesCount")));
        anime.setSynopsis(ctx.formParam("synopsis"));
        anime.setImageUrl(ctx.formParam("imageUrl"));
        anime.setReleaseDate(LocalDate.parse(ctx.formParam("releaseDate")));

        animeRepository.updateAnime(anime);
        ctx.redirect("/dashboard");
    }

    public void delete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        animeRepository.deleteAnime(id);
        ctx.redirect("/dashboard");
    }
}
