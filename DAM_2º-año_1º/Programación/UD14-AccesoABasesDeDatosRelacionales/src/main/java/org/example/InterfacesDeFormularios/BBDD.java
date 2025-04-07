package org.example.InterfacesDeFormularios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BBDD {
    private static final String url = "jdbc:mysql://localhost:3306/registro";
    private static final String user = "root";
    private static final String password = "1234";

    public BBDD() {
    }

    public static Connection connect() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
