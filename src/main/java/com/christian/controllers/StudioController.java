package com.christian.controllers;

import java.util.Map;
import com.christian.models.Studio;
import com.christian.models.User;
import com.christian.repository.StudioRepository;
import io.javalin.http.Context;

public class StudioController {

    private final StudioRepository studioRepository;

    public StudioController(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    public void createForm(Context ctx) {
        User currentUser = ctx.sessionAttribute("currentUser");
        Map<String, Object> model = studioRepository.getStudioModel(currentUser);
        ctx.render("studio-create.ftl", model);
    }

    public void create(Context ctx) {
        Studio studio = new Studio();
        boolean active = "true".equals(ctx.formParam("active"));

        studio.setName(ctx.formParam("name"));
        studioRepository.createStudio(studio);

        if (active) {
            ctx.redirect("/anime/create");
            return;
        }

        ctx.redirect("/dashboard");

    }

    public void delete(Context ctx) {
        int studioId = Integer.parseInt(ctx.pathParam("id"));
        studioRepository.deleteStudio(studioId);
        ctx.redirect("/dashboard");
    }
}
