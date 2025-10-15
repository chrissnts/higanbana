package com.christian.controllers;

import com.christian.models.Role;
import com.christian.models.User;
import com.christian.services.DashboardService;

import io.javalin.http.Context;

public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    public void dashboard(Context ctx) {
        User admin = ctx.sessionAttribute("currentUser");

        if (admin == null || admin.getRole() != Role.ADMIN) {
            ctx.redirect("/login");
            return;
        }

        ctx.render("dashboard.ftl", dashboardService.getDashboardModel(admin));
    }

    
    public void deleteUser(Context ctx) {
        int userId = Integer.parseInt(ctx.pathParam("id"));
        dashboardService.deleteUser(userId);
        ctx.redirect("/dashboard");
    }

    
    public void deleteAnime(Context ctx) {
        int animeId = Integer.parseInt(ctx.pathParam("id"));
        dashboardService.deleteAnime(animeId);
        ctx.redirect("/dashboard");
    }

   
    public void deleteStudio(Context ctx) {
        int studioId = Integer.parseInt(ctx.pathParam("id"));
        dashboardService.deleteStudio(studioId);
        ctx.redirect("/dashboard");
    }

    
    public void deleteGenre(Context ctx) {
        int genreId = Integer.parseInt(ctx.pathParam("id"));
        dashboardService.deleteGenre(genreId);
        ctx.redirect("/dashboard");
    }
}
