package org.example.ControladorDAO;

import org.example.Modelo.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.Configuracion.Conexion.getConnection;

public class UsuariosDAO {

    public UsuariosDAO() {
    }

    public static boolean combrobarUsuarios(Usuarios usuarios) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT usuario FROM usuarios WHERE usuario = ?")) {

            ps.setString(1, usuarios.getUsuario());
            ResultSet resultSet = ps.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean insertarUsuarios(Usuarios usuarios) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO usuarios (usuario, password) VALUES (?,?)")) {

            ps.setString(1, usuarios.getUsuario());
            ps.setString(2, usuarios.getPassword());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }


    }
}
