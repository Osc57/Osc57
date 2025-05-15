package org.example.Controlador;

import org.example.Modelo.Cliente;
import org.example.Modelo.Recepcionista;

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

    public static Cliente cargarDniCliente(String dni){
        Cliente cliente = null;

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cliente WHERE dni=?;")) {

            preparedStatement.setString(1, dni);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                cliente = new Cliente();
                cliente.setDni(resultSet.getString("dni"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellidos(resultSet.getString("apellidos"));;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar al cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        return cliente;
    }
}

