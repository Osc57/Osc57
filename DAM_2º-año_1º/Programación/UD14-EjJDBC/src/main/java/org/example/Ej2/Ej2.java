package org.example.Ej2;


import java.sql.*;

public class Ej2 {
    private static final String url = "jdbc:mysql://localhost:3306/alumnos";
    private static final String user = "root";
    private static final String password = "1234";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
