package com.christian.controllers;

import com.christian.models.Role;
import com.christian.models.User;
import io.javalin.http.Handler;
import java.util.Collections;

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
            ctx.render("home.ftl", Collections.singletonMap("user", currentUser));
        }
    };

    public Handler favorites = ctx -> {
        User currentUser = ctx.sessionAttribute("currentUser");

        if (currentUser == null) {
            ctx.redirect("/login");
            return;
        }

        ctx.render("favorites.ftl", Collections.singletonMap("user", currentUser));
    };
}
