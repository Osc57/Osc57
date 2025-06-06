package org.example.Controlador;

import org.example.Modelo.Cita;
import org.example.Modelo.Cliente;
import org.example.Modelo.Trabajador;

import java.sql.*;
import java.util.ArrayList;

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

    public static ArrayList<Cita> mostrarCitaCliente (String dni){
        ArrayList<Cita> listaCitas = new ArrayList<>();

        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM cita WHERE dni_cliente=?")) {

            ps.setString(1, dni);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Cita cita = new Cita();
                cita.setId(resultSet.getInt("id"));
                Timestamp timestamp = resultSet.getTimestamp("fechaCita");
                cita.setFechaCita(timestamp.toLocalDateTime());
                cita.setDniCliente(resultSet.getString("dni_cliente"));
                cita.setIdTratamiento(resultSet.getInt("id_tratamiento"));

                listaCitas.add(cita);

            }

        } catch (SQLException ex) {
        }
        return listaCitas;
    }
}
