package com.christian.controllers;
import com.christian.models.Role;
import com.christian.models.User;
import com.christian.repository.interfaces.DashboardRepository;
import io.javalin.http.Context;

public class DashboardController {

    private final DashboardRepository dashboardRepository;

    public DashboardController(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public void dashboard(Context ctx) {
        User admin = ctx.sessionAttribute("currentUser");

        if (admin == null || admin.getRole() != Role.ADMIN) {
            ctx.redirect("/login");
            return;
        }

        ctx.render("admin/dashboard.ftl", dashboardRepository.getDashboardModel(admin));
    }
}
