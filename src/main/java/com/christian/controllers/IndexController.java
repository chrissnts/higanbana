package com.christian.controllers;

import io.javalin.http.Handler;

public class IndexController {

     public Handler get = ctx -> {

        try {
            ctx.render("index.ftl");

        } catch (Exception e) {
            ctx.status(400);
            ctx.result("Error: " + e.getMessage());
        }

    };
}
