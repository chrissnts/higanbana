package com.christian.controllers;

import com.christian.models.Studio;
import com.christian.repository.StudioRepository;
import io.javalin.http.Context;

public class StudioController {

    private final StudioRepository studioRepository;

    public StudioController(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    public void create(Context ctx) {
        Studio studio= new Studio();
        studio.setName(ctx.formParam("name"));
        studioRepository.createStudio(studio);
        
    }
   
    public void delete(Context ctx) {
        int studioId = Integer.parseInt(ctx.pathParam("id"));
        studioRepository.deleteStudio(studioId);
        ctx.redirect("/dashboard");
    }
}
