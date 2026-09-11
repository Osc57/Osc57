package org.example.Controlador;

import org.example.Modelo.Tratamiento;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.Controlador.Conexion.connect;

public class ControladorTratamientos {
    public ControladorTratamientos() {
    }

    public static DefaultComboBoxModel<Tratamiento> cargarTratamientos(){
        DefaultComboBoxModel<Tratamiento> tratamientos = new DefaultComboBoxModel<>();

        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM tratamientos");) {

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){

                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("tipo");

                tratamientos.addElement(new Tratamiento(id,nombre));
            }


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los tratamientos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return tratamientos;
    }
}
