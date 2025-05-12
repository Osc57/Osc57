package org.example.Controlador;

import org.example.Modelo.Cliente;

import javax.swing.*;
import java.sql.*;

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
}

