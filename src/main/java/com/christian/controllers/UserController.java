package com.christian.controllers;
import com.christian.models.Role;
import com.christian.models.User;
import com.christian.repository.interfaces.UserRepository;
import io.javalin.http.Context;
import java.util.HashMap;
import java.util.Map;

public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void home(Context ctx) {
        User currentUser = ctx.sessionAttribute("currentUser");

        if (currentUser == null) {
            ctx.redirect("/login");
            return;
        }

        if (currentUser.getRole() == Role.ADMIN) {
            ctx.redirect("/dashboard");
            return;
        }

        Map<String, Object> model = new HashMap<>();
        model.put("user", currentUser);
        ctx.render("home.ftl", model);
    }

    public void favorites(Context ctx) {
        User currentUser = ctx.sessionAttribute("currentUser");

        if (currentUser == null) {
            ctx.redirect("/login");
            return;
        }

        Map<String, Object> model = new HashMap<>();
        model.put("user", currentUser);
        ctx.render("favorites.ftl", model);
    }

    public void delete(Context ctx) {
        int userId = Integer.parseInt(ctx.pathParam("id"));
        userRepository.deleteUser(userId);
        ctx.redirect("/dashboard");
    }
}
