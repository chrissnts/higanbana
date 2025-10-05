package com.christian.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    private Long id;
    private String userName;
    private String email;
    private String password;
    private boolean admin = false;
    private List<Anime> watchedAnimes = new ArrayList<>();
    private List<Anime> watchlistAnime = new ArrayList<>();
    private List<Review> reviews = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private List<User> friends = new ArrayList<>();
    private List<Anime> favoriteAnimes = new ArrayList<>();

    public User(String userName, String email, String password, boolean admin) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Anime> getWatchedAnimes() {
        return Collections.unmodifiableList(watchedAnimes);
    }

    public List<Anime> getWatchlistAnime() {
        return Collections.unmodifiableList(watchlistAnime);
    }

    public List<Review> getReviews() {
        return Collections.unmodifiableList(reviews);
    }

    public List<Comment> getComments() {
        return Collections.unmodifiableList(comments);
    }

    public List<User> getFriends() {
        return Collections.unmodifiableList(friends);
    }

    public List<Anime> getFavoriteAnimes() {
        return Collections.unmodifiableList(favoriteAnimes);
    }


    public void addFriend(User friend) {
        this.friends.add(friend);
    }

    public void addFavoriteAnime(Anime anime) {
        this.favoriteAnimes.add(anime);
    }

    public void addWatchedAnime(Anime anime) {
        this.watchedAnimes.add(anime);
    }

    public void addToWatchlist(Anime anime) {
        this.watchlistAnime.add(anime);
    }


    





    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", isAdmin=" + admin + "]";
    }
}
