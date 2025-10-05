package com.christian.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Review {
    private Long id;
    private Anime anime;
    private User user;
    private String content;
    private int rating;
    private LocalDateTime createdAt;
    private List<Comment> comments = new ArrayList<>();

    public Review() {
    }

    public Review(Long id, Anime anime, User user, String content, int rating, LocalDateTime createdAt) {
        this.id = id;
        this.anime = anime;
        this.user = user;
        this.content = content;
        this.rating = rating;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {

        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating must be between 0 and 10.");
        }
        this.rating = rating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    @Override
    public String toString() {
        return "Review [id=" + id + ", anime=" + anime.getTitle() + ", user=" + user.getuserName() +
                ", rating=" + rating + ", createdAt=" + createdAt + "]";
    }

}
