package com.christian.repository.interfaces;

import com.christian.models.Genre;
import com.christian.models.User;
import java.util.List;
import java.util.Map;

public interface GenreRepository {
    void createGenre(Genre genre);
    void updateGenre(Genre genre);
    void deleteGenre(int id);
    Genre findById(int id);
    Genre findByIdWithAnimes(int id);
    List<Genre> getAllGenres();
    Map<String, Object> getGenreModel(User admin);
}
