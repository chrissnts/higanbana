package com.christian.repository;

import com.christian.dao.GenreDao;
import com.christian.models.Genre;
import com.christian.models.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenreRepository {

    private final GenreDao genreDao;

    public GenreRepository(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    public void createGenre(Genre genre) {
        genreDao.save(genre);
    }

    public void deleteGenre(int id) {
        genreDao.delete(id);
    }

    public List<Genre> getAllGenres() {
        try {
            List<Genre> genres = genreDao.findAll();
            return genres != null ? Collections.unmodifiableList(genres) : Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Map<String, Object> getGenreModel(User admin) {
        Map<String, Object> model = new HashMap<>();
        model.put("admin", admin);
        return model;
    }

}
