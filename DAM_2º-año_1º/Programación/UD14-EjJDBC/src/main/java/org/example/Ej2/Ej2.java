package org.example.Ej2;

import org.example.Conexion;

import java.sql.*;

/**
 * Una vez diseñada y creada la Base de datos y la respectiva tabla, crea un programa
 * en Java que introduzca al menos 10 estudiantes.
 **/

public class Ej2 extends Conexion {

    public static void main(String[] args) {

        String[][] alumnos = {
                {"Juan", "Pérez", "Calle 123"},
                {"María", "Gómez", "Av. Principal 45"},
                {"Carlos", "Ramírez", "Carrera 78"},
                {"Ana", "Fernández", "Diagonal 30"},
                {"Luis", "Hernández", "Calle 50"},
                {"Sofía", "Díaz", "Av. Secundaria 10"},
                {"Pedro", "Martínez", "Calle 90"},
                {"Laura", "Sánchez", "Carrera 25"},
                {"José", "Rodríguez", "Av. Central 55"},
                {"Elena", "López", "Calle 70"}
        };

        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO alumno (nombre,apellidos,direccion) VALUES (?,?,?)");


            for (String[] alumno : alumnos) {
                preparedStatement.setString(1, alumno[0]);
                preparedStatement.setString(2, alumno[1]);
                preparedStatement.setString(3, alumno[2]);
                preparedStatement.executeUpdate();
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connect().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
