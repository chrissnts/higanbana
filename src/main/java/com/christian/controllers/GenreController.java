package com.christian.controllers;

import java.util.Map;

import com.christian.models.Genre;
import com.christian.models.User;
import com.christian.repository.GenreRepository;
import io.javalin.http.Context;

public class GenreController {

    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public void createForm(Context ctx) {
        User currentUser = ctx.sessionAttribute("currentUser");
        Map<String, Object> model = genreRepository.getGenreModel(currentUser);
        ctx.render("genre-create.ftl", model);
    }

    public void create(Context ctx) {
        Genre genre = new Genre();
        boolean active = "true".equals(ctx.formParam("active"));

        genre.setName(ctx.formParam("name"));
        genreRepository.createGenre(genre);

        System.out.println("active");

        if (active) {
            ctx.redirect("/anime/create");
            return;
        }

        ctx.redirect("/dashboard");
    }

    public void delete(Context ctx) {
        int genreId = Integer.parseInt(ctx.pathParam("id"));
        genreRepository.deleteGenre(genreId);
        ctx.redirect("/dashboard");
    }
}
