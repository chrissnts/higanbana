package com.christian.controllers;
import java.util.Map;
import com.christian.models.Genre;
import com.christian.models.User;
import com.christian.repository.interfaces.GenreRepository;
import io.javalin.http.Context;

public class GenreController {

    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public void createForm(Context ctx) {
        User currentUser = ctx.sessionAttribute("currentUser");
        Map<String, Object> model = genreRepository.getGenreModel(currentUser);
        ctx.render("genre/create.ftl", model);
    }

    public void create(Context ctx) {
        Genre genre = new Genre();
        boolean active = "true".equals(ctx.formParam("active"));

        genre.setName(ctx.formParam("name"));
        genreRepository.createGenre(genre);

        if (active) {
            ctx.redirect("/animes/create");
            return;
        }

        ctx.redirect("/dashboard");
    }

    public void editForm(Context ctx) {
        int genreId = Integer.parseInt(ctx.pathParam("id"));
        Genre genre = genreRepository.findById(genreId);

        if (genre == null) {
            ctx.status(404).result("Genre not found");
            return;
        }

        User currentUser = ctx.sessionAttribute("currentUser");
        Map<String, Object> model = genreRepository.getGenreModel(currentUser);
        model.put("genre", genre);

        ctx.render("genre/edit.ftl", model);
    }

    public void edit(Context ctx) {
        int genreId = Integer.parseInt(ctx.pathParam("id"));
        Genre genre = genreRepository.findById(genreId);

        if (genre == null) {
            ctx.status(404).result("Genre not found");
            return;
        }

        genre.setName(ctx.formParam("name"));
        genreRepository.updateGenre(genre);

        ctx.redirect("/dashboard");
    }

    public void view(Context ctx) {
    int genreId = Integer.parseInt(ctx.pathParam("id"));
    Genre genre = genreRepository.findByIdWithAnimes(genreId);

    if (genre == null) {
        ctx.status(404).result("Genre not found");
        return;
    }

    User currentUser = ctx.sessionAttribute("currentUser");

    Map<String, Object> model = genreRepository.getGenreModel(currentUser);
    model.put("genre", genre);
    model.put("admin", currentUser); 
    ctx.render("genre/view.ftl", model);
}

    public void delete(Context ctx) {
        int genreId = Integer.parseInt(ctx.pathParam("id"));
        genreRepository.deleteGenre(genreId);
        ctx.redirect("/dashboard");
    }
}
