package org.example.Controlador;

import org.example.Modelo.Jefe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.Controlador.Conectar.connect;

public class BBDDJefe {

    public Jefe cargarJefe() {
        Jefe trabajador = new Jefe();
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trabajadores WHERE dni_jefe IS NULL;")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                trabajador.setDni(resultSet.getString("dni"));
                trabajador.setNombre(resultSet.getString("nombre"));
                trabajador.setApellidos(resultSet.getString("apellidos"));
                trabajador.setTelefono(resultSet.getInt("telefono"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trabajador;
    }

}
