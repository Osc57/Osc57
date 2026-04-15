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

    public static int combrobarUsuarios(Usuarios usuarios) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT usuario, password FROM usuarios WHERE usuario = ?")) {

            ps.setString(1, usuarios.getUsuario());
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return 0;
            }

            String password = rs.getString("password");

            if (password.equals(usuarios.getPassword())) {
                return 1;
            }

            return 2;

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
