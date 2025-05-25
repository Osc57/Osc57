package org.example.Controlador;


import org.example.Modelo.Historial;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Controlador.Conexion.connect;

public class ControladorHistorial {

    public static ArrayList<Historial> cargarHistorial(String dni) {
        ArrayList<Historial> historiales = new ArrayList<>();

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM historial WHERE dni_cliente = ?")) {
            preparedStatement.setString(1, dni);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Historial historial = new Historial();
                    historial.setDniCliente(resultSet.getString("dni_cliente"));
                    historial.setIdTratamiento(resultSet.getInt("id_tratamiento"));
                    historial.setFechaTratamiento(resultSet.getDate("fecha_tratamiento"));

                    historiales.add(historial);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al cargar el historial: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return historiales;
    }
}
