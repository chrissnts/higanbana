package com.christian.controllers;
import org.mindrot.jbcrypt.BCrypt;
import com.christian.dao.UserDao;
import com.christian.models.Role;
import com.christian.models.User;
import io.javalin.http.Context;

public class AuthenticationController  {
    private final UserDao userDao;

    public AuthenticationController() {
        this.userDao = new UserDao();
    }

    public void register(Context ctx) {
        String username = ctx.formParam("username");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");

        if (username == null || username.isEmpty() ||
            email == null || email.isEmpty() ||
            password == null || password.isEmpty()) {
            ctx.redirect("/register?error=All+camps+must+be+provided");
            return;
        }

        if (userDao.findByEmail(email) != null) {
            ctx.redirect("/register?error=E-mail+already+in+use");
            return;
        }

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User newUser = new User(username, email, hashedPassword, Role.USER);
        userDao.create(newUser);

        ctx.redirect("/login");
    }

    public void login(Context ctx) {
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");

        if (email == null || password == null) {
            ctx.redirect("/login?error=E-mail+and+password+must+be+provided");
            return;
        }

        User user = userDao.findByEmail(email);

        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            ctx.sessionAttribute("currentUser", user);
            if (user.getRole() == Role.ADMIN) {
                ctx.redirect("/dashboard");
            } else {
                ctx.redirect("/home");
            }
        } else {
            ctx.redirect("/login?error=E-mail+or+password+incorrect");
        }
    }

    public void logout(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/login");
    }
}
