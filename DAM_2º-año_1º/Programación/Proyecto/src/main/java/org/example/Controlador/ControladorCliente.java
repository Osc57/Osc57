package org.example.Controlador;

import org.example.Modelo.Cliente;

import javax.swing.*;
import java.sql.*;

import static org.example.Controlador.Conexion.connect;

public class ControladorCliente {

    public ControladorCliente() {
    }

    public Cliente enviarDatosCliente(Cliente cliente){

        if (cliente.getDni().isEmpty() || cliente.getNombre().isEmpty() || cliente.getApellidos().isEmpty()){
            JOptionPane.showMessageDialog(null, "DNI, Nombre y Apellidos son campos obligatorios", "Error",JOptionPane.ERROR_MESSAGE);

        }

        if (!cliente.getDni().matches("[0-9]{8}[A-Za-z]")){
            JOptionPane.showMessageDialog(null, "DNI invalido", "Exito", JOptionPane.INFORMATION_MESSAGE);

        }

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

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return cliente;
    }

    /*
    * Cliente nuevoCliente = new Cliente();
            nuevoCliente.setDni(txtDNI.getText());
            nuevoCliente.setNombre(txtNombre.getText());
            nuevoCliente.setApellidos(txtApellidos.getText());
            nuevoCliente.setDireccion(txtDireccion.getText());
            nuevoCliente.setTelefono(Integer.parseInt(txtTelefono.getText()));

            controladorCliente.enviarDatosCliente(nuevoCliente);
    * */
}

