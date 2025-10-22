package com.christian.routes;

import com.christian.controllers.*;
import com.christian.dao.*;
import com.christian.models.*;
import com.christian.repository.*;
import com.christian.repository.interfaces.*;
import io.javalin.Javalin;

public class Routes {
    private final AuthenticationController authController;
    private final UserController userController;
    private final DashboardController dashboardController;
    private final AnimeController animeController;
    private final StudioController studioController;
    private final GenreController genreController;

    public Routes() {

        this.authController = new AuthenticationController();
        UserDao userDao = new UserDao();
        UserRepository userRepository = new UserRepositoryImpl(userDao);
        this.userController = new UserController(userRepository);
        AnimeDao animeDao = new AnimeDao();
        StudioDao studioDao = new StudioDao();
        GenreDao genreDao = new GenreDao();

        StudioRepository studioRepository = new StudioRepositoryImpl(studioDao);
        GenreRepository genreRepository = new GenreRepositoryImpl(genreDao);
        AnimeRepository animeRepository = new AnimeRepositoryImpl(animeDao, studioRepository, genreRepository);
        DashboardRepository dashboardRepository = new DashboardRepositoryImpl(userRepository, animeRepository,studioRepository, genreRepository);

        this.dashboardController = new DashboardController(dashboardRepository);
        this.animeController = new AnimeController(animeRepository);
        this.studioController = new StudioController(studioRepository);
        this.genreController = new GenreController(genreRepository);
    }

    public void registerRoutes(Javalin app) {
        
        // Landing Page
        app.get("/", ctx -> ctx.render("index.ftl"));
        app.get("/about", ctx -> ctx.render("home/about.ftl"));

        // Authentication Forms
        app.get("/login", ctx -> ctx.render("/home/login.ftl"));
        app.get("/register", ctx -> ctx.render("home/register.ftl"));

        // Authentication Actions
        app.post("/login", authController::login);
        app.post("/register", authController::register);
        app.post("/logout", authController::logout);

        // User
        app.get("/home", userController::home);
        app.get("/favorites", userController::favorites);
        
        // Dashboard (admin)
        app.get("/dashboard", dashboardController::dashboard);

        // Admin/Animes
        app.get("/animes/create", animeController::createForm);
        app.post("/animes/create", animeController::create);
        app.get("/animes/{id}/edit", animeController::editForm);
        app.post("/animes/{id}/edit", animeController::edit);
        app.get("/animes/{id}/view", animeController::view);
        app.post("/animes/{id}/delete", animeController::delete);

        // Admin/users
        // app.get("/users/{id}/edit", userController::editForm);
        // app.post("/users/{id}/edit", userController::edit);
        app.get("/users/{id}/view", userController::view);
        app.post("/users/{id}/delete", userController::delete);
        

        // Admin/studios
        app.get("/studios/create", studioController::createForm);
        app.post("/studios/create", studioController::create);
        app.get("/studios/{id}/edit", studioController::editForm);
        app.post("/studios/{id}/edit", studioController::edit);
        app.get("/studios/{id}/view", studioController::view);
        app.post("/studios/{id}/delete", studioController::delete);

        // Admin/genres
        app.get("/genres/create", genreController::createForm);
        app.post("/genres/create", genreController::create);
        app.get("/genres/{id}/edit", genreController::editForm);
        app.post("/genres/{id}/edit", genreController::edit);
        app.get("/genres/{id}/view", genreController::view);
        app.post("/genres/{id}/delete", genreController::delete);
    }
}
