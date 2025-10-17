package com.christian.repository;

import com.christian.dao.StudioDao;
import com.christian.models.Studio;
import java.util.Collections;
import java.util.List;

public class StudioRepository {

    private final StudioDao studioDao;

    public StudioRepository(StudioDao studioDao) {
        this.studioDao = studioDao;
    }

    public void createStudio(Studio studio){
        studioDao.save(studio);
    }


    public void deleteStudio(int id) {
        studioDao.delete(id);
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
}
