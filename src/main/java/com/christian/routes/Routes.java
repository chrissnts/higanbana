package com.christian.routes;

import com.christian.controllers.AuthenticationController;
import com.christian.controllers.UserController;

import io.javalin.Javalin;

public class Routes {
    private final AuthenticationController authController;
    private final UserController userController;

    public Routes() {
        this.authController = new AuthenticationController();
        this.userController = new UserController();
    }

    public void registerRoutes(Javalin app) {
        
        // Landing Page
        app.get("/", ctx -> ctx.render("index.ftl")); 

        // Landing Page: About
        app.get("/about", ctx -> ctx.render("about.ftl"));

       // Authentication Forms
        app.get("/login", ctx -> ctx.render("login.ftl")); 
        app.get("/register", ctx -> ctx.render("register.ftl"));

        // Authentication Actions
        app.post("/login", authController::login);
        app.post("/register", authController::register);
        app.post("/logout", authController::logout);

        // User
        app.get("/home", userController.home);
        app.get("/favorites", userController.favorite);

        // Admin
        app.get("/dashboard", userController.dashboard);
    }
}
