package org.example.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BBDD {
    private static final String URL = "jdbc:mysql://localhost:3306/proyectoOscar";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public BBDD() {
    }

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
