package com.christian.controllers;

import com.christian.models.Genre;
import com.christian.repository.GenreRepository;
import io.javalin.http.Context;

public class GenreController {

    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public void create(Context ctx) {
        Genre genre = new Genre();
        genre.setName(ctx.formParam("name"));
        genreRepository.createGenre(genre);
    }
    
    public void delete(Context ctx) {
        int genreId = Integer.parseInt(ctx.pathParam("id"));
        genreRepository.deleteGenre(genreId);
        ctx.redirect("/dashboard");
    }
}
