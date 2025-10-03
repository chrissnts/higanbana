package com.christian.routes;

import com.christian.controllers.IndexController;
import io.javalin.Javalin;

public class Routes {
    private IndexController indexController;

    public Routes() {
        this.indexController = new IndexController();
    }

    public void registerRoutes(Javalin app) {
        app.get("/", indexController.get);
        
    }
}