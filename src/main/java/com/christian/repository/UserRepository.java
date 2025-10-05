package com.christian.repository;

import java.util.ArrayList;
import java.util.List;
import com.christian.models.User;

public class UserRepository {

    private static List<User> users = new ArrayList<>();

    
    static {
        
        users.add(new User("admin", "admin@example.com", "1234", true));
        
        users.add(new User("cliente", "cliente@example.com", "1234", false));
    }

    
    public static void add(User user) {
        users.add(user);
    }

    
    public static User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    public static List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
