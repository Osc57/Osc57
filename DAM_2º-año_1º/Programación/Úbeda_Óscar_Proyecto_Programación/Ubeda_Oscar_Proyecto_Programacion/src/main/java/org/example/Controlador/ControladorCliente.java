package org.example.Controlador;

import org.example.Modelo.Cliente;
import org.example.Modelo.Recepcionista;
import org.example.Modelo.Trabajador;
import org.example.Modelo.Tratamiento;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

import static org.example.Controlador.Conexion.connect;

public class ControladorCliente {

    public ControladorCliente() {
    }

    public boolean enviarDatosCliente(Cliente cliente) {

        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO cliente (dni, nombre, apellidos, direccion, telefono, fechaDeAlta) VALUES (?, ?, ?, ?, ?, ?)")) {

            java.sql.Date fechaActual = new java.sql.Date(System.currentTimeMillis());

            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getTelefono());
            ps.setDate(6, fechaActual);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public static ArrayList<Cliente> cargarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cliente;")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setDni(resultSet.getString("dni"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellidos(resultSet.getString("apellidos"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setTelefono(resultSet.getInt("telefono"));

                clientes.add(cliente);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return clientes;
    }

    public static boolean eliminarCliente(String dni) {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cliente WHERE dni=?;")) {

            preparedStatement.setString(1, dni);
            int filasAfectadas = preparedStatement.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar al cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static Cliente cargarDniCliente(String dni) {
        Cliente cliente = null;

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cliente WHERE dni=?;")) {

            preparedStatement.setString(1, dni);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                cliente = new Cliente();
                cliente.setDni(resultSet.getString("dni"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellidos(resultSet.getString("apellidos"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar al cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        return cliente;
    }

    public static boolean comprobarDNICliente(String dni) {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cliente WHERE dni=?;")) {

            preparedStatement.setString(1, dni);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar el DNI del Cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean darCitaClientes(String fecha, String dni, int id) {
        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO cita (fechaCita, dni_cliente, id_tratamiento) VALUES (?, ?, ?)")) {

            ps.setString(1, fecha);
            ps.setString(2, dni);
            ps.setInt(3, id);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            return false;
        }
    }

    public static boolean editarCliente(String dni, String nombre, String apellidos, String direccion, Integer telefono) {

        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement("UPDATE cliente SET nombre = ?, apellidos = ?, direccion = ?, telefono = ? WHERE dni = ?")) {

            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setString(3, direccion);
            ps.setObject(4, telefono);
            ps.setString(5, dni);

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.err.println("[Error] No se pudo actualizar el cliente: " + ex.getMessage());
            return false;
        }
    }

    public static Cliente obtenerClientePorDNI(String dni){//Obtengo todos los datos del cliente
        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM cliente WHERE dni = ?")) {

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setDni(rs.getString("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getInt("telefono"));
                return cliente;
            }
            return null;
        }catch (SQLException ex){
            return null;
        }
    }

}

