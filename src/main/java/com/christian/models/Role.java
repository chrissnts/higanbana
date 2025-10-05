package com.christian.models;

public enum Role {
    ADMIN(1),
    USER(2);

    private final int id;

    Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

  
    public static Role fromId(int id) {
        for (Role role : values()) {
            if (role.getId() == id) return role;
        }
        return USER; 
    }
}