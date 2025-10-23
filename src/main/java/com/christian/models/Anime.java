package com.christian.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Anime {
    private Long id;
    private int episodesCount;
    private String title;
    private String synopsis;
    private String imageUrl;
    private double rating;
    private LocalDate releaseDate;
    private Studio studio;
    private List<Genre> genres = new ArrayList<>();
    private List<Review> reviews = new ArrayList<>();
    private LocalDateTime deletedAt;

    public Anime(Long id, int episodesCount, String title, String synopsis, String imageUrl, double rating,
            LocalDate releaseDate, Studio studio, List<Genre> genres, List<Review> reviews, LocalDateTime deletedAt) {
        this.id = id;
        this.episodesCount = episodesCount;
        this.title = title;
        this.synopsis = synopsis;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.studio = studio;
        this.genres = genres != null ? genres : new ArrayList<>();
        this.reviews = reviews != null ? reviews : new ArrayList<>();
        this.deletedAt = deletedAt;
    }

    // Construtor de teste
    public Anime(Long id, String title, int episodesCount, double rating) {
        this.id = id;
        this.title = title;
        this.episodesCount = episodesCount;
        this.rating = rating;
    }

    public Anime() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEpisodesCount() {
        return episodesCount;
    }

    public void setEpisodesCount(int episodesCount) {
        this.episodesCount = episodesCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "Anime [id=" + id + ", episodesCount=" + episodesCount + ", title=" + title + ", synopsis=" + synopsis
                + ", imageUrl=" + imageUrl + ", rating=" + rating + ", releaseDate=" + releaseDate + ", studio="
                + studio + ", genres=" + genres + ", reviews=" + reviews + ", deletedAt=" + deletedAt + "]";
    }

    public double getAverageRating() {
        if (reviews == null || reviews.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Review review : reviews) {
            sum += review.getRating();
        }
        return sum / reviews.size();
    }

    public void setFriendReviews(List<Review> friendReviews) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFriendReviews'");
    }
}
