package com.christian.routes;

import com.christian.controllers.*;
import com.christian.repository.*;
import com.christian.dao.*;
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
        this.userController = new UserController();

        
        UserDao userDao = new UserDao();
        AnimeDao animeDao = new AnimeDao();
        StudioDao studioDao = new StudioDao();
        GenreDao genreDao = new GenreDao();

        UserRepository userRepository = new UserRepository(userDao);
        StudioRepository studioRepository = new StudioRepository(studioDao);
        GenreRepository genreRepository = new GenreRepository(genreDao);
        AnimeRepository animeRepository = new AnimeRepository(animeDao, studioRepository, genreRepository);


        DashboardRepository dashboardRepository = new DashboardRepository(
            userRepository,
            animeRepository,
            studioRepository,
            genreRepository
        );

        
        this.dashboardController = new DashboardController(dashboardRepository);
        this.animeController = new AnimeController(animeRepository);
        this.studioController = new StudioController(studioRepository);
        this.genreController = new GenreController(genreRepository);
    }

    public void registerRoutes(Javalin app) {
        // Landing Page
        app.get("/", ctx -> ctx.render("index.ftl"));
        app.get("/about", ctx -> ctx.render("about.ftl"));

        // Authentication Forms
        app.get("/login", ctx -> ctx.render("login.ftl"));
        app.get("/register", ctx -> ctx.render("register.ftl"));

        // Authentication Actions
        app.post("/login", authController::login);
        app.post("/register", authController::register);
        app.post("/logout", authController::logout);

        // User
        app.get("/home", userController::home);
        app.get("/favorites", userController::favorites);

        // Dashboard (only admin view)
        app.get("/dashboard", dashboardController::dashboard);

        // Animes
        app.get("/animes/create", animeController::createForm);
        app.post("/animes/create", animeController::create);
        app.get("/animes/{id}/edit", animeController::editForm);
        app.post("/animes/{id}/edit", animeController::edit);
        app.post("/animes/{id}/delete", animeController::delete);

        // Admin/users
        app.post("/users/{id}/delete", userController::delete);

        // Admin/studios
        app.get("/studios/create", studioController::createForm);
        app.post("/studios/create", studioController::create);
        app.post("/studios/{id}/delete", studioController::delete);

        // Admin/genres
        app.get("/genres/create", genreController::createForm);
        app.post("/genres/create", genreController::create);
        app.post("/genres/{id}/delete", genreController::delete);
    }
}
