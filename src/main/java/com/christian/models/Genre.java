package com.christian.models;

public class Genre {

    private Long id;
    private String name;

    public Genre(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = (long) id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre [id=" + id + ", name=" + name + "]";
    }

    
}
