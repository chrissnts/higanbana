package com.christian.repository;

import com.christian.dao.UserDao;
import com.christian.models.User;
import java.util.Collections;
import java.util.List;

public class UserRepository {

    private final UserDao userDao;

    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
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

    public void deleteUser(int id) {
        userDao.delete(id);
    }
}
