package com.christian.services;

import com.christian.dao.*;
import com.christian.models.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardService {

    private final UserDao userDao;
    private final AnimeDao animeDao;
    private final StudioDao studioDao;
    private final GenreDao genreDao;

    public DashboardService(UserDao userDao, AnimeDao animeDao, StudioDao studioDao, GenreDao genreDao) {
        this.userDao = userDao;
        this.animeDao = animeDao;
        this.studioDao = studioDao;
        this.genreDao = genreDao;
    }

    public List<User> getAllUsers() {
        try {
            List<User> users = userDao.findAll();
            return users != null ? Collections.unmodifiableList(users) : Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Anime> getAllAnimes() {
        try {
            List<Anime> animes = animeDao.findAll();
            return animes != null ? Collections.unmodifiableList(animes) : Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Studio> getAllStudios() {
        try {
            List<Studio> studios = studioDao.findAll();
            return studios != null ? Collections.unmodifiableList(studios) : Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
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

    public void deleteUser(int id) {
        userDao.delete(id);
    }

    public void deleteAnime(int id) {
        animeDao.delete(id);
    }

    public void deleteStudio(int id) {
        studioDao.delete(id);
    }

    public void deleteGenre(int id) {
        genreDao.delete(id);
    }

    public Map<String, Object> getDashboardModel(User admin) {
        Map<String, Object> model = new HashMap<>();
        model.put("admin", admin);

        List<User> users = getAllUsers();
        model.put("users", users);

        List<Anime> animes = getAllAnimes();
        model.put("animes", animes);

        List<Studio> studios = getAllStudios();
        model.put("studios", studios);

        List<Genre> genres = getAllGenres();
        model.put("genres", genres);

        return model;
    }
}
