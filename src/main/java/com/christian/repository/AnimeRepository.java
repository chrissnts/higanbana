package com.christian.repository;

import com.christian.dao.AnimeDao;
import com.christian.models.Anime;
import com.christian.models.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimeRepository {

    private final AnimeDao animeDao;
    private final StudioRepository studioRepository;
    private final GenreRepository genreRepository;

    // ✅ Corrigido: construtor agora recebe também os repositórios necessários
    public AnimeRepository(AnimeDao animeDao, StudioRepository studioRepository, GenreRepository genreRepository) {
        this.animeDao = animeDao;
        this.studioRepository = studioRepository;
        this.genreRepository = genreRepository;
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

    public Anime getAnimeById(int id) {
        return animeDao.findById(id);
    }

    public void createAnime(Anime anime) {
        animeDao.save(anime);
    }

    public void editAnime(Anime anime) {
        animeDao.edit(anime);
    }

    public void deleteAnime(int id) {
        animeDao.delete(id);
    }

    
    public Map<String, Object> getAnimeModel(User admin) {
        Map<String, Object> model = new HashMap<>();
        model.put("studios", studioRepository.getAllStudios());
        model.put("genres", genreRepository.getAllGenres());
        model.put("admin", admin);
        return model;
    }
}
