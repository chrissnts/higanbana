package com.christian.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String JDBC_URL = "jdbc:mysql://wagnerweinert.com.br:3306/info23_CHRISTIAN";
    private static final String USER = "info23_CHRISTIAN";
    private static final String PASSWORD = "info23_CHRISTIAN";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }
}