package com.christian.repository;

import com.christian.models.User;


public interface UserRepositoryImpl {
    User findById(int id);
    User findByEmail(String email);
    void save(User user);
    void update(User user);
    void delete(int id);
    
}