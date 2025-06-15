package com.example.projekcik.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/system_zarzadzania_sklepem";
    private static final String USER = "postgres";
    private static final String PASSWORD = "lukasz112233";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}