package com.christian.models;

import java.time.LocalDateTime;

public class Comment {
    private Long id;
    private User user;
    private String content;
    private Review review;
    private LocalDateTime createdAt;


    public Comment() {
    }

    public Comment(Long id, User user, String content, Review review, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.review = review;
        this.createdAt = createdAt;
    }

    // Getters e Setters
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Comment [id=" + id + ", user=" + (user != null ? user.getUserName() : "null") +
                ", content=" + content + ", createdAt=" + createdAt + "]";
    }

}
