package com.christian.models;

import java.util.List;

public class Genre {

    private Long id;
    private String name;
    private List<Anime> animes;

    public Genre(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = (long) id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     public List<Anime> getAnimes() {
        return animes;
    }

    public void setAnimes(List<Anime> animes) {
        this.animes = animes;
    }

    
    @Override
    public String toString() {
        return "Genre [id=" + id + ", name=" + name + "]";
    }

    
}
