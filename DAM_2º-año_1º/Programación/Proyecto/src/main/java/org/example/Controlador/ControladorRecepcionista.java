package org.example.Controlador;

import org.example.Modelo.Cliente;
import org.example.Modelo.Recepcionista;

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

    public static ArrayList<Recepcionista> cargarRecepcionistas() {

        ArrayList<Recepcionista> recepcionistas = new ArrayList<>();

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trabajadores WHERE dni_jefe IS NOT NULL;")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Recepcionista trabajador = new Recepcionista();
                trabajador.setDni(resultSet.getString("dni"));
                trabajador.setNombre(resultSet.getString("nombre"));
                trabajador.setApellidos(resultSet.getString("apellidos"));
                trabajador.setTelefono(resultSet.getInt("telefono"));

                recepcionistas.add(trabajador);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recepcionistas;
    }

    public boolean enviarDatosRecepcionista(Recepcionista recepcionista, String dni) {

        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO trabajadores (dni, nombre, apellidos, telefono, dni_jefe) VALUES (?, ?, ?, ?, ?)")) {

            ps.setString(1, recepcionista.getDni());
            ps.setString(2, recepcionista.getNombre());
            ps.setString(3, recepcionista.getApellidos());
            ps.setInt(4, recepcionista.getTelefono());
            ps.setString(5, dni);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }
}
