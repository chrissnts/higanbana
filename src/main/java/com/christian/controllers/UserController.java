package com.christian.controllers;

import com.christian.models.Role;
import com.christian.models.User;
import io.javalin.http.Handler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserController {

    public Handler home = ctx -> {
        User currentUser = ctx.sessionAttribute("currentUser");

        if (currentUser == null) {
            ctx.redirect("/login");
            return;
        }

        if (currentUser.getRole() == Role.ADMIN) {
            ctx.redirect("/dashboard"); // apenas redireciona
        } else {
            Map<String, Object> model = new HashMap<>();
            model.put("user", currentUser);
            ctx.render("home.ftl", model);
        }
    };

    public Handler favorites = ctx -> {
        User currentUser = ctx.sessionAttribute("currentUser");

        if (currentUser == null) {
            ctx.redirect("/login");
            return;
        }

        Map<String, Object> model = new HashMap<>();
        model.put("user", currentUser);
        ctx.render("favorites.ftl", model);
    };
}
