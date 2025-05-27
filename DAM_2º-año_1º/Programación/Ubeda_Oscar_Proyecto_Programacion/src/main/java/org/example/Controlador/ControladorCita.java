package org.example.Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.Controlador.Conexion.connect;

public class ControladorCita {

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
}
