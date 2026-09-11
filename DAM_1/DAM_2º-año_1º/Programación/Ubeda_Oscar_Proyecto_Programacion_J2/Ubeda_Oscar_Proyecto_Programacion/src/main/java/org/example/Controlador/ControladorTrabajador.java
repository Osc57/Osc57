package org.example.Controlador;

import org.example.Modelo.Cliente;
import org.example.Modelo.Recepcionista;
import org.example.Modelo.Trabajador;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Controlador.Conexion.connect;

public class ControladorTrabajador {
    public ControladorTrabajador() {
    }

    public static Trabajador cargarDniTrabajador(String dni) {
        Trabajador trabajador = null;

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trabajadores WHERE dni = ?;")) {

            preparedStatement.setString(1, dni);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                trabajador = new Trabajador();
                trabajador.setDni(resultSet.getString("dni"));
                trabajador.setNombre(resultSet.getString("nombre"));
                trabajador.setApellidos(resultSet.getString("apellidos"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar al cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        return trabajador;
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

    public static boolean comprobarDNITrabajador(String dni) {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trabajadores WHERE dni=?;")) {

            preparedStatement.setString(1, dni);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar el DNI del Trabajador: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static Trabajador resgistroTrabajador(String dni) {
        Trabajador trabajador = null;
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trabajadores WHERE dni=?;")) {

            preparedStatement.setString(1, dni);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                trabajador = new Trabajador(
                        resultSet.getString("dni"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellidos")
                );
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar el DNI del Trabajador: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return trabajador;
    }

    public boolean enviarDatosTrabajador(Trabajador recepcionista) {

        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO trabajadores (dni, nombre, apellidos, telefono) VALUES (?, ?, ?, ?)")) {

            ps.setString(1, recepcionista.getDni());
            ps.setString(2, recepcionista.getNombre());
            ps.setString(3, recepcionista.getApellidos());
            ps.setInt(4, recepcionista.getTelefono());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public static boolean actualizarPrimerLoginEnBD(Trabajador trabajador) {
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement("UPDATE loggin SET primer_login = ? WHERE usuario = ?")) {
            stmt.setBoolean(1, false); // Ya no es primer login
            stmt.setString(2, trabajador.getDni());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean esPrimerLogin(Trabajador trabajador) {
        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT primer_login FROM loggin WHERE usuario = ?")) {
            ps.setString(1, trabajador.getDni());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean("primer_login");
                }
                return false; // Si no encuentra el usuario
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al verificar primer login", e);
        }
    }

    public static Trabajador obtenerTrabajadorPorDNI(String dni){//Obtengo todos los datos del cliente
        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM trabajadores WHERE dni = ?")) {

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Trabajador trabajador = new Trabajador();
                trabajador.setDni(rs.getString("dni"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setApellidos(rs.getString("apellidos"));
                trabajador.setTelefono(rs.getInt("telefono"));
                return trabajador;
            }
            return null;
        }catch (SQLException ex){
            return null;
        }
    }

    public static boolean editarTrabajador(String dni, String nombre, String apellidos, Integer telefono) {

        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement("UPDATE trabajadores SET nombre = ?, apellidos = ?, telefono = ? WHERE dni = ?")) {

            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setObject(3, telefono);
            ps.setString(4, dni);

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.err.println("[Error] No se pudo actualizar el cliente: " + ex.getMessage());
            return false;
        }
    }

    public static Trabajador mostrarDatosTrabajador(String dni) {
        Trabajador trabajador = null;

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trabajadores WHERE dni = ?;")) {

            preparedStatement.setString(1, dni);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                trabajador = new Trabajador();
                trabajador.setDni(resultSet.getString("dni"));
                trabajador.setNombre(resultSet.getString("nombre"));
                trabajador.setApellidos(resultSet.getString("apellidos"));
                trabajador.setTelefono(resultSet.getInt("telefono"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar al cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        return trabajador;
    }

}
