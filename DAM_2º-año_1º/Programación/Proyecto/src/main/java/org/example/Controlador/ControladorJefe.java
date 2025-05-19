package org.example.Controlador;

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

    public static ArrayList<Jefe> cargarJefe() {

        ArrayList<Jefe> jefes = new ArrayList<>();
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trabajadores WHERE dni_jefe IS NULL;")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Jefe trabajador = new Jefe();
                trabajador.setDni(resultSet.getString("dni"));
                trabajador.setNombre(resultSet.getString("nombre"));
                trabajador.setApellidos(resultSet.getString("apellidos"));
                trabajador.setTelefono(resultSet.getInt("telefono"));

                jefes.add(trabajador);

            }

            return jefes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean enviarDatosJefe(Jefe jefe) {
        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO trabajadores (dni, nombre, apellidos, telefono, dni_jefe) VALUES (?, ?, ?, ?, ?)")) {

            ps.setString(1, jefe.getDni());
            ps.setString(2, jefe.getNombre());
            ps.setString(3, jefe.getApellidos());
            ps.setInt(4, jefe.getTelefono());
            ps.setString(5, null);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public static ArrayList<Trabajador> cargarTrabajadores() {

        ArrayList<Trabajador> trabajadores = new ArrayList<>();

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trabajadores;")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Trabajador trabajador = new Trabajador();
                trabajador.setDni(resultSet.getString("dni"));
                trabajador.setNombre(resultSet.getString("nombre"));
                trabajador.setApellidos(resultSet.getString("apellidos"));
                trabajador.setTelefono(resultSet.getInt("telefono"));

                trabajadores.add(trabajador);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trabajadores;
    }

    public static boolean eliminarTrabajador(String dni) {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM trabajadores WHERE dni=?;")) {

            preparedStatement.setString(1, dni);
            int filasAfectadas = preparedStatement.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar al trabajador: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
