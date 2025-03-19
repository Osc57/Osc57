package org.example.Ej3;

import org.example.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Intenta insertar un nuevo usuario con un ID existente, ¿Qué ocurre? ¿Has gestionado
 * la excepción correctamente?
 **/

public class Ej3 extends Conexion {
    public static void main(String[] args) {

        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO alumno (id,nombre,apellidos,direccion) VALUES (?,?,?,?)");

            preparedStatement.setInt(1,7);
            preparedStatement.setString(2,"Rodolfo");
            preparedStatement.setString(3,"Hernandez");
            preparedStatement.setString(4,"Calle La Avenida");

            preparedStatement.executeUpdate();


        } catch (Exception e) {
            System.out.println("No se puede introducir los datos debido a que el id es erroneo");
        } finally {
            try {
                connect().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
