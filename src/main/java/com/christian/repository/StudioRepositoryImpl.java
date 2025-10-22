package com.christian.repository;
import com.christian.dao.StudioDao;
import com.christian.models.Studio;
import com.christian.models.User;
import com.christian.repository.interfaces.StudioRepository;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudioRepositoryImpl implements StudioRepository {

    private final StudioDao studioDao;

    public StudioRepositoryImpl(StudioDao studioDao) {
        this.studioDao = studioDao;
    }

    @Override
    public void createStudio(Studio studio) {
        studioDao.create(studio);
    }

    @Override
    public void updateStudio(Studio studio) {
        studioDao.update(studio);
    }

    @Override
    public void deleteStudio(int id) {
        studioDao.delete(id);
    }

    @Override
    public int count(){
        return studioDao.count();
    }

    @Override
    public Studio findById(int id) {
       return studioDao.findById(id);
    }

    @Override
    public Studio findByIdWithAnimes(int id){
        return studioDao.findByIdWithAnimes(id);
    }

    @Override
    public List<Studio> getAllStudios() {
        try {
            List<Studio> studios = studioDao.findAll();
            return studios != null ? Collections.unmodifiableList(studios) : Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Map<String, Object> getStudioModel(User admin) {
        Map<String, Object> model = new HashMap<>();
        model.put("admin", admin);
        return model;
    }
}