package com.christian.repository;

import com.christian.models.User;
import java.util.HashMap;
import java.util.Map;

public class DashboardRepository {

    private final UserRepository userRepository;
    private final AnimeRepository animeRepository;
    private final StudioRepository studioRepository;
    private final GenreRepository genreRepository;

    public DashboardRepository(
            UserRepository userRepository,
            AnimeRepository animeRepository,
            StudioRepository studioRepository,
            GenreRepository genreRepository
    ) {
        this.userRepository = userRepository;
        this.animeRepository = animeRepository;
        this.studioRepository = studioRepository;
        this.genreRepository = genreRepository;
    }

    public Map<String, Object> getDashboardModel(User admin) {
        Map<String, Object> model = new HashMap<>();
        model.put("admin", admin);
        model.put("users", userRepository.getAllUsers());
        model.put("animes", animeRepository.getAllAnimes());
        model.put("studios", studioRepository.getAllStudios());
        model.put("genres", genreRepository.getAllGenres());
        return model;
    }
}
