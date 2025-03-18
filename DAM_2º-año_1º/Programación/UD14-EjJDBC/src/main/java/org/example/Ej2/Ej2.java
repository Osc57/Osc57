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
        try (Connection connection = connect()){
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO alumno (nombre,apellido,direccion) VALUES (?,?,?)");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {

        }
    }
}
