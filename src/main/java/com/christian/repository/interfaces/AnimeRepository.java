package com.christian.repository.interfaces;

import com.christian.models.Anime;
import com.christian.models.User;
import java.util.List;
import java.util.Map;

public interface AnimeRepository {
    void createAnime(Anime anime);
    void updateAnime(Anime anime);
    void deleteAnime(int id);
    Anime findById(int id);
    List<Anime> getAllAnimes();
    List<Anime> searchAnimesByTitle(String title);
    Map<String, Object> getAnimeModel(User admin);
}