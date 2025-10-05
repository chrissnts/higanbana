package com.christian.routes;

import com.christian.controllers.*;
import io.javalin.Javalin;

public class Routes {
    private UserController userController;

    public Routes() {
        this.userController = new UserController();
    }

    public void registerRoutes(Javalin app) {

        app.get("/", userController.get);
        app.post("/login", userController.post); 

        app.get("/register", userController.registerGet);
        app.post("/register", userController.registerPost);

        app.get("/client/home", userController.clientHome);

        

        // app.post("/logout", ctx -> {
        // ctx.sessionAttribute("currentUser", null);
        // ctx.redirect("/");
        // });

    }
}