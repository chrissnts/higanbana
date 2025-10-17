package com.christian.repository;

import com.christian.dao.GenreDao;
import com.christian.models.Genre;
import java.util.Collections;
import java.util.List;

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
    
}
