package org.iesch.interfaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Listar {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/alumnos";
        String user = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM alumno");

            System.out.println("ID\tNombre\t\tApellidos\t\t\tDirección");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String direccion = resultSet.getString("direccion");

                System.out.println(id + "\t" + nombre + "\t\t" + apellidos + "\t\t" + direccion);
            }
            resultSet.close();
            connection.close();

        } catch (SQLException e) {
            System.err.println("Error connecting to the database");
            e.printStackTrace();
        }
    }
}