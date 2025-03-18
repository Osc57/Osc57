package org.example.Ej2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ej2 {
    private static final String url = "jdbc:mysql://localhost:3306/alumnos";
    private static final String user = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO alumno (nombre,apellido,direccion) VALUES (?,?,?)");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
