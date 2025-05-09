package org.example.Controlador;

import org.example.Modelo.Recepcionista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Controlador.Conexion.connect;

public class ControladorRecepcionista {
    public ControladorRecepcionista() {
    }

    public Connection updateRecepcionista(String documento) {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE recepcionista SET dni = ?")) {

            preparedStatement.setString(1, documento);
            int filas = preparedStatement.executeUpdate();

            if (filas == 0) {
                try (PreparedStatement statement = connection.prepareStatement("INSERT INTO recepcionista (dni) VALUES (?)")) {
                    statement.setString(1, documento);
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connect();
    }

    public static ArrayList<Recepcionista> cargarTrabajadores() {

        ArrayList<Recepcionista> recepcionistas = new ArrayList<>();

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trabajadores WHERE dni_jefe IS NOT NULL;")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Recepcionista trabajador = new Recepcionista();
                trabajador.setDni(resultSet.getString("dni"));
                trabajador.setNombre(resultSet.getString("nombre"));
                trabajador.setApellidos(resultSet.getString("apellidos"));
                trabajador.setTelefono(resultSet.getInt("telefono"));

                recepcionistas.add(trabajador);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recepcionistas;
    }
}
