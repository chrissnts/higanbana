package com.christian.repository.interfaces;
import com.christian.models.User;
import java.util.List;

public interface UserRepository {
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    int count();
    User findById(int id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    
   
}
