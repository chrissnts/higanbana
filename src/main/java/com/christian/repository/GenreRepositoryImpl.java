package com.christian.repository;
import com.christian.dao.GenreDao;
import com.christian.models.Genre;
import com.christian.models.User;
import com.christian.repository.interfaces.GenreRepository;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenreRepositoryImpl implements GenreRepository {

    private final GenreDao genreDao;

    public GenreRepositoryImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public void createGenre(Genre genre) {
        genreDao.create(genre);
    }

    @Override
    public void updateGenre(Genre genre) {
        genreDao.update(genre);
    }

    @Override
    public void deleteGenre(int id) {
        genreDao.delete(id);
    }

    @Override
    public int count(){
        return genreDao.count();
    }

    @Override
    public Genre findById(int id) {
        return genreDao.findById(id);
    }

    @Override
    public Genre findByIdWithAnimes(int id){
        return genreDao.findByIdWithAnimes(id);
    }

    @Override
    public List<Genre> getAllGenres() {
        try {
            List<Genre> genres = genreDao.findAll();
            return genres != null ? Collections.unmodifiableList(genres) : Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Map<String, Object> getGenreModel(User admin) {
        Map<String, Object> model = new HashMap<>();
        model.put("admin", admin);
        return model;
    }
}