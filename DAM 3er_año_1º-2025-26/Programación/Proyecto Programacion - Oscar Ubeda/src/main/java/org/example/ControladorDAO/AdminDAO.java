package org.example.ControladorDAO;

import org.example.Modelo.Admin;
import org.example.Modelo.Empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.Configuracion.Conexion.getConnection;

public class AdminDAO {

    public AdminDAO() {
    }

    public static boolean combrobarAdmin(Admin admin) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT usuario FROM login WHERE usuario = ?")) {

            ps.setString(1, admin.getUsuario());
            ResultSet resultSet = ps.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean insertarAdmin(Admin admin) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO login (usuario, password) VALUES (?,?)")) {

            ps.setString(1, admin.getUsuario());
            ps.setString(2, admin.getPassword());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }


    }
}
