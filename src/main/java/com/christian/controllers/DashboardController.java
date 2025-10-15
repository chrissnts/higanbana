package com.christian.controllers;

import com.christian.models.*;
import com.christian.services.DashboardService;
import io.javalin.http.Handler;

import java.util.Map;

public class DashboardController {

    private final DashboardService dashboardService;
    public final Handler dashboard;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;

        this.dashboard = ctx -> {
            User currentUser = ctx.sessionAttribute("currentUser");

            if (currentUser == null || !currentUser.getRole().equals(Role.ADMIN)) {
                ctx.redirect("/login");
                return;
            }

            Map<String, Object> model = dashboardService.getDashboardModel(currentUser);
            ctx.render("dashboard.ftl", model);
        };
    }
}

