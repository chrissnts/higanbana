package com.christian.repository;

import io.javalin.http.Context;

public interface AuthenticationRepositoryImpl {
    void register(Context ctx);
    void login(Context ctx);
    void logout(Context ctx);
}