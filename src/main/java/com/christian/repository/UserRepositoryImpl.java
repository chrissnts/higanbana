package com.christian.repository;

import com.christian.dao.UserDao;
import com.christian.models.User;
import com.christian.repository.interfaces.UserRepository;

import java.util.Collections;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final UserDao userDao;

    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(User user) {
        userDao.create(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.delete(id);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        try {
            List<User> users = userDao.findAll();
            return users != null ? Collections.unmodifiableList(users) : Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
