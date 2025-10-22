package com.christian.repository;

import com.christian.models.User;
import com.christian.repository.interfaces.AnimeRepository;
import com.christian.repository.interfaces.StudioRepository;
import com.christian.repository.interfaces.GenreRepository;
import com.christian.repository.interfaces.UserRepository;
import com.christian.repository.interfaces.DashboardRepository;

import java.util.HashMap;
import java.util.Map;

public class DashboardRepositoryImpl implements DashboardRepository {

    private final UserRepository userRepository;
    private final AnimeRepository animeRepository;
    private final StudioRepository studioRepository;
    private final GenreRepository genreRepository;

    public DashboardRepositoryImpl(UserRepository userRepository, AnimeRepository animeRepository, StudioRepository studioRepository,GenreRepository genreRepository) {

        this.userRepository = userRepository;
        this.animeRepository = animeRepository;
        this.studioRepository = studioRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public Map<String, Object> getDashboardModel(User admin) {
        Map<String, Object> model = new HashMap<>();
        model.put("admin", admin);
        model.put("users", userRepository.getAllUsers());
        model.put("animes", animeRepository.getAllAnimes());
        model.put("studios", studioRepository.getAllStudios());
        model.put("genres", genreRepository.getAllGenres());
        model.put("totalAnimes", animeRepository.count());
        model.put("totalUsers", userRepository.count());
        model.put("totalGenres", genreRepository.count());
        model.put("totalStudios", studioRepository.count());

        return model;
    }
}
