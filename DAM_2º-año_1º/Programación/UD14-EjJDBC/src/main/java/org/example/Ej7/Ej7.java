package org.example.Ej7;

import org.example.Conexion;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Añade a tu interfaz un método que permita listar todos los estudiantes existentes.
 **/

public class Ej7 extends Conexion {
    public static void main(String[] args) {
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM alumno;")){

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellidos");
                String direccion = resultSet.getString("direccion");

                System.out.println(id + "\t"  + " | " + "\t" + nombre + "\t" + " | " + "\t" + apellido + "\t" + " | " + "\t" + direccion);
            }

        } catch (Exception e) {
            System.out.println("Error al listar los datos: " + e.getMessage());
        }
    }
}
