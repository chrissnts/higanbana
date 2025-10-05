package com.christian.models;

import java.time.LocalDateTime;


public class WatchListEntry {
    private Long id;
    private User user;
    private Anime anime;
    private LocalDateTime addedAt;
    private LocalDateTime updatedAt;
    private boolean watched;
    private Integer rating;

    public WatchListEntry(Long id, User user, Anime anime) {
        this.id = id;
        this.user = user;
        this.anime = anime;
        this.addedAt = LocalDateTime.now();
        this.watched = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    
    
}