package com.christian.controllers;
import java.util.Map;
import com.christian.models.Studio;
import com.christian.models.User;
import com.christian.repository.interfaces.StudioRepository;
import io.javalin.http.Context;

public class StudioController {

    private final StudioRepository studioRepository;

    public StudioController(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    public void createForm(Context ctx) {
        User currentUser = ctx.sessionAttribute("currentUser");
        Map<String, Object> model = studioRepository.getStudioModel(currentUser);
        ctx.render("studio/create.ftl", model);
    }

    public void create(Context ctx) {
        Studio studio = new Studio();
        boolean active = "true".equals(ctx.formParam("active"));

        studio.setName(ctx.formParam("name"));
        studioRepository.createStudio(studio);

        if (active) {
            ctx.redirect("/animes/create");
            return;
        }

        ctx.redirect("/dashboard");
    }

    public void editForm(Context ctx) {
        int studioId = Integer.parseInt(ctx.pathParam("id"));
        Studio studio = studioRepository.findById(studioId);

        if (studio == null) {
            ctx.status(404).result("Studio not found");
            return;
        }

        User currentUser = ctx.sessionAttribute("currentUser");
        Map<String, Object> model = studioRepository.getStudioModel(currentUser);
        model.put("studio", studio);
        ctx.render("studio/edit.ftl", model);
    }

    public void edit(Context ctx) {
        int studioId = Integer.parseInt(ctx.pathParam("id"));
        Studio studio = studioRepository.findById(studioId);

        if (studio == null) {
            ctx.status(404).result("Studio not found");
            return;
        }

        studio.setName(ctx.formParam("name"));
        studioRepository.updateStudio(studio);
        ctx.redirect("/dashboard");
    }

    public void view(Context ctx) {
    int studioId = Integer.parseInt(ctx.pathParam("id"));
    Studio studio = studioRepository.findByIdWithAnimes(studioId);
    if (studio == null) {
        ctx.status(404).result("Studio not found");
        return;
    }

    User currentUser = ctx.sessionAttribute("currentUser");

    Map<String, Object> model = studioRepository.getStudioModel(currentUser);
    model.put("studio", studio);
    model.put("admin", currentUser);
    ctx.render("studio/view.ftl", model);
}


    public void delete(Context ctx) {
        int studioId = Integer.parseInt(ctx.pathParam("id"));
        studioRepository.deleteStudio(studioId);
        ctx.redirect("/dashboard");
    }
}
