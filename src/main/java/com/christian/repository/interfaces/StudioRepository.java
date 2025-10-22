package com.christian.repository.interfaces;

import com.christian.models.Studio;
import com.christian.models.User;
import java.util.List;
import java.util.Map;

public interface StudioRepository {
    void createStudio(Studio studio);
    void updateStudio(Studio studio);
    void deleteStudio(int id);
    int count();
    Studio findById(int id);
    Studio findByIdWithAnimes(int id);
    List<Studio> getAllStudios();
    Map<String, Object> getStudioModel(User admin);
}
