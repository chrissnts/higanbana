package com.christian.controllers;

import com.christian.repository.UserRepository;
import com.christian.models.*;

import io.javalin.http.Handler;
import java.util.Collections;

public class UserController {

    public Handler get = ctx -> {
        try {
            ctx.render("index.ftl");
        } catch (Exception e) {
            ctx.status(400);
            ctx.result("Error: " + e.getMessage());
        }
    };

    public Handler post = ctx -> {
        try {
            String email = ctx.formParam("email");
            String password = ctx.formParam("password");

            if (email == null || password == null) {
                throw new Exception("Email and password must be provided.");
            }

            User user = UserRepository.findByEmail(email);

            if (user == null || !user.getPassword().equals(password)) {
                ctx.status(401);
                ctx.render("index.ftl", Collections.singletonMap("error", "E-mail or Password incorrect."));
                return;
            }

            ctx.sessionAttribute("currentUser", user);

            if (user.isAdmin()) {
                ctx.redirect("/admin/dashboard");
            } else {
                ctx.redirect("/client/home");
            }

        } catch (Exception e) {
            ctx.status(400);
            ctx.result("Error: " + e.getMessage());
        }
    };

    public Handler registerGet = ctx -> {
        ctx.render("register.ftl");
    };

    public Handler registerPost = ctx -> {
        String userName = ctx.formParam("username");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");

        if (email == null || password == null) {
            ctx.status(400).result("Email and password must be provided.");
            return;
        }

        User user = new User(userName, email, password, false);
        UserRepository.add(user);

        ctx.redirect("/");
    };

    public Handler clientHome = ctx -> {
        User currentUser = ctx.sessionAttribute("currentUser");

        if (currentUser == null || currentUser.isAdmin()) {
            ctx.redirect("/"); 
            return;
        }

        ctx.render("home.ftl", Collections.singletonMap("user", currentUser));
    };

}
