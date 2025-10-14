package com.christian.controllers;

import com.christian.models.*;
import io.javalin.http.Handler;
import java.util.*;

public class DashboardController {

    public Handler dashboard = ctx -> {
        User currentUser = ctx.sessionAttribute("currentUser");

        if (currentUser == null || currentUser.getRole() != Role.ADMIN) {
            ctx.redirect("/login");
            return;
        }

        // Dados de exemplo - futuramente buscar do banco
        List<Anime> animes = Arrays.asList(
                new Anime(1L, "One Piece", 1000, 4.8),
            new Anime(2L, "Hunter x Hunter", 175, 4.8),
            new Anime(3L, "Jujutsu Kaisen", 100, 4.8),
            new Anime(4L, "Darling in The Franxx", 25, 4.8),
            new Anime(5L, "Naruto", 800, 6.9)
        );

    Map<String, Object> model = new HashMap<>();model.put("admin",currentUser);model.put("animes",animes);

    ctx.render("dashboard.ftl",model);
};}
