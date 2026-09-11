package org.example.Controlador;

import org.example.Modelo.Cita;
import org.example.Modelo.Cliente;
import org.example.Modelo.Trabajador;

import java.sql.*;
import java.util.ArrayList;
import java.util.Stack;

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

    public static ArrayList<Cita> mostrarCitaCliente(String dni) {
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

    public static boolean actualizarCita(Cita cambiar) {
        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement("UPDATE cita SET fechaCita = ?, dni_cliente = ?, id_tratamiento = ? WHERE id = ?")) {

            ps.setTimestamp(1, Timestamp.valueOf(cambiar.getFechaCita()));
            ps.setString(2, cambiar.getDniCliente());
            ps.setInt(3, cambiar.getIdTratamiento());
            ps.setInt(4, cambiar.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar la cita", e);
        }
    }

    public static boolean citaDuplicada(Cita cita) {
        try (Connection con = connect();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT id FROM cita WHERE fechaCita = ? AND id != ?")) {

            ps.setTimestamp(1, Timestamp.valueOf(cita.getFechaCita()));
            ps.setInt(2, cita.getId()); // Si es nueva cita (id=0), no excluirá nada

            return ps.executeQuery().next(); // true si existe duplicado

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean eliminarCita(Cita cita) {
        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM cita WHERE id = ?")) {

            ps.setInt(1, cita.getId()); // Obtenemos el ID directamente del objeto
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la cita con ID: " + cita.getId(), e);
        }
    }




}
