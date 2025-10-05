package com.christian;

import com.christian.config.AppConfig;
import com.christian.routes.Routes;

public class Main {

    public static void main(String[] args) {

        Routes routes = new Routes();
        AppConfig appConfig = new AppConfig();

        routes.registerRoutes(appConfig.startApp());
        

    }
}