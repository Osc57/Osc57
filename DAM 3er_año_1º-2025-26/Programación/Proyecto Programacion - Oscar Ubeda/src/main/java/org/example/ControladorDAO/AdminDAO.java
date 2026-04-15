package org.example.ControladorDAO;

import org.example.Modelo.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.Configuracion.Conexion.getConnection;

public class AdminDAO {

    public AdminDAO() {
    }

    public static boolean combrobarAdmin (Admin admin){

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT usuario")){

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
