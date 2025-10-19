package com.christian.repository;
import com.christian.dao.AnimeDao;
import com.christian.models.Anime;
import com.christian.models.User;
import com.christian.repository.interfaces.AnimeRepository;
import com.christian.repository.interfaces.StudioRepository;
import com.christian.repository.interfaces.GenreRepository;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimeRepositoryImpl implements AnimeRepository {

    private final AnimeDao animeDao;
    private final StudioRepository studioRepository;
    private final GenreRepository genreRepository;

    public AnimeRepositoryImpl(AnimeDao animeDao, StudioRepository studioRepository, GenreRepository genreRepository) {
        this.animeDao = animeDao;
        this.studioRepository = studioRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public void createAnime(Anime anime) {
        animeDao.create(anime);
    }

    @Override
    public void updateAnime(Anime anime) {
        animeDao.update(anime);
    }

    @Override
    public void deleteAnime(int id) {
        animeDao.delete(id);
    }

    @Override
    public Anime findById(int id) {
        return animeDao.findById(id);
    }

    @Override
    public List<Anime> getAllAnimes() {
        try {
            List<Anime> animes = animeDao.findAll();
            return animes != null ? Collections.unmodifiableList(animes) : Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<Anime> searchAnimesByTitle(String title) {
        try {
            List<Anime> animes = animeDao.findByTitle(title);
            return animes != null ? Collections.unmodifiableList(animes) : Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Map<String, Object> getAnimeModel(User admin) {
        Map<String, Object> model = new HashMap<>();
        model.put("studios", studioRepository.getAllStudios());
        model.put("genres", genreRepository.getAllGenres());
        model.put("admin", admin);
        return model;
    }
}