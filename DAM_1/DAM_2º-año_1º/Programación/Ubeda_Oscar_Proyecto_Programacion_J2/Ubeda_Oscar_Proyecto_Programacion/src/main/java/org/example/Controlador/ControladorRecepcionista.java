package org.example.Controlador;

import org.example.Modelo.Cliente;
import org.example.Modelo.Recepcionista;
import org.example.Modelo.Tratamiento;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Controlador.Conexion.connect;

public class ControladorRecepcionista {
    public ControladorRecepcionista() {
    }

    public static boolean comprobarLogginRecepcionista(String user, String password) {
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

    public static boolean updateRecepcionista(String dni) {
        try (Connection connection = connect()) {
            try (PreparedStatement deleteStatement = connection.prepareStatement(
                    "DELETE FROM recepcionista")) {
                deleteStatement.executeUpdate();
            }

            try (PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO recepcionista (dni) VALUES (?)")) {
                insertStatement.setString(1, dni);
                insertStatement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el recepcionista", e);
        }
    }

}
