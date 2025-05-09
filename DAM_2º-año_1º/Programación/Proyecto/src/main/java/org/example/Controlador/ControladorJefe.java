package org.example.Controlador;

import org.example.Modelo.Jefe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Controlador.Conexion.connect;

public class ControladorJefe {

    public ControladorJefe() {
    }

    public static ArrayList<Jefe> cargarJefe() {

        ArrayList<Jefe> jefes = new ArrayList<>();
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trabajadores WHERE dni_jefe IS NULL;")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Jefe trabajador = new Jefe();
                trabajador.setDni(resultSet.getString("dni"));
                trabajador.setNombre(resultSet.getString("nombre"));
                trabajador.setApellidos(resultSet.getString("apellidos"));
                trabajador.setTelefono(resultSet.getInt("telefono"));

                jefes.add(trabajador);

            }

            return jefes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
