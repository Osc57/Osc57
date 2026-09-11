package org.example.Controlador;

import org.example.Modelo.Cliente;
import org.example.Modelo.Jefe;
import org.example.Modelo.Recepcionista;
import org.example.Modelo.Trabajador;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Controlador.Conexion.connect;

public class ControladorJefe {

    public ControladorJefe() {
    }

    public static boolean comprobarLogginAdmin(String user, String password) {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM loggin WHERE usuario=? AND contrasena=?;")) {

            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar al cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;

        }
    }

    public static boolean verificarContrasenaActual(Trabajador trabajador, String contrasenaIngresada) {
        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement("SELECT contrasena FROM loggin WHERE usuario = ?")) {

            ps.setString(1, trabajador.getDni());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String contrasenaBD = rs.getString("contrasena");
                    return contrasenaBD.equals(contrasenaIngresada);
                }
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al verificar contraseña", e);
        }
    }

    public static boolean cambiarContrasena(Trabajador dni, String passw){
        try (Connection connection = connect();
        PreparedStatement ps = connection.prepareStatement("UPDATE loggin SET contrasena=? WHERE usuario=?;")){

            ps.setString(1, passw);
            ps.setString(2, dni.getDni());

            int filasActualizadas = ps.executeUpdate();

            return filasActualizadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
