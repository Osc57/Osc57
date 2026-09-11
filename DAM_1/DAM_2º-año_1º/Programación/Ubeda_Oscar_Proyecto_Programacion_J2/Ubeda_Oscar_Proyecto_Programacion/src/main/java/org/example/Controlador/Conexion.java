package org.example.Controlador;

import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/proyectoOscar";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public Conexion() {
    }

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
