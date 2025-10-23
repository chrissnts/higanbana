package com.christian.controllers;

import com.christian.models.Role;
import com.christian.models.User;
import com.christian.models.Anime;
import com.christian.models.Review;
import com.christian.repository.interfaces.UserRepository;
import com.christian.repository.interfaces.AnimeRepository;
import io.javalin.http.Context;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserController {

    private final UserRepository userRepository;
    private final AnimeRepository animeRepository;

    public UserController(UserRepository userRepository, AnimeRepository animeRepository) {
        this.userRepository = userRepository;
        this.animeRepository = animeRepository;
    }

    public void home(Context ctx) {
        User currentUser = ctx.sessionAttribute("currentUser");

        if (currentUser == null) {
            ctx.redirect("/login");
            return;
        }

        if (currentUser.getRole() == Role.ADMIN) {
            ctx.redirect("admin/dashboard");
            return;
        }

        Map<String, Object> model = new HashMap<>();
        model.put("user", currentUser);
        ctx.render("user/home.ftl", model);
    }

    public void addFavorites(Context ctx) {
        User currentUser = ctx.sessionAttribute("currentUser");
        if (currentUser == null) {
            ctx.redirect("/login");
            return;
        }

        Long animeId = Long.parseLong(ctx.pathParam("animeId"));
        Anime anime = animeRepository.findById(animeId);
        if (anime == null) {
            ctx.status(404).result("Anime not found");
            return;
        }

        currentUser.addFavoriteAnime(anime);
        userRepository.updateUser(currentUser);
        ctx.redirect("/anime/" + animeId);
    }

    public void viewAnime(Context ctx) {
        User currentUser = ctx.sessionAttribute("currentUser");
        if (currentUser == null) {
            ctx.redirect("/login");
            return;
        }

        Long animeId = Long.parseLong(ctx.pathParam("id"));
        Anime anime = animeRepository.findById(animeId);
        if (anime == null) {
            ctx.status(404).result("Anime not found");
            return;
        }
        
        Map<String, Object> model = new HashMap<>();
        model.put("anime", anime);
        model.put("user", currentUser);
        ctx.render("user/viewAnime.ftl", model);
    }

    public void favorites(Context ctx) {
        User currentUser = ctx.sessionAttribute("currentUser");

        if (currentUser == null) {
            ctx.redirect("/login");
            return;
        }

        List<Anime> favoriteAnimes = currentUser.getFavoriteAnimes();

        Map<Long, Double> userRatings = new HashMap<>();

        for (Anime anime : favoriteAnimes) {
            Review review = currentUser.getReviews().stream()
                    .filter(r -> r.getAnime().getId().equals(anime.getId()))
                    .findFirst()
                    .orElse(null);

            userRatings.put(anime.getId(), review != null ? review.getRating() : 0.0);
        }

        Map<String, Object> model = new HashMap<>();
        model.put("user", currentUser);
        model.put("favorites", favoriteAnimes);
        model.put("userRatings", userRatings);
        ctx.render("user/favorites.ftl", model);
    }

    public void view(Context ctx) {
        int userId = Integer.parseInt(ctx.pathParam("id"));
        User user = userRepository.findById(userId);
        if (user == null) {
            ctx.status(404).result("User not found");
            return;
        }

        Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        User currentUser = ctx.sessionAttribute("currentUser");
        model.put("admin", currentUser);
        ctx.render("user/view.ftl", model);
    }

    public void delete(Context ctx) {
        int userId = Integer.parseInt(ctx.pathParam("id"));
        userRepository.deleteUser(userId);
        ctx.redirect("/dashboard");
    }

    public void animes(Context ctx) {
        User currentUser = ctx.sessionAttribute("currentUser");

        if (currentUser == null) {
            ctx.redirect("/login");
            return;
        }

        List<Anime> allAnimes = animeRepository.getAllAnimes();

        Map<String, Object> model = new HashMap<>();
        model.put("user", currentUser);
        model.put("animes", allAnimes);

        ctx.render("user/animes.ftl", model);
    }
}
