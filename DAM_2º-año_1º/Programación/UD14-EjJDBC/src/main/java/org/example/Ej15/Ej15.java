package org.example.Ej15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static org.example.Conexion.connect;

/**
 * Realiza un programa que nos liste los cursos existentes, y nos permita seleccionar
 * uno, ahora nos mostrará los datos de los alumnos matriculados en dicho curso.
 **/

public class Ej15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT id,nombre FROM cursos;")) {

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");

                System.out.println(id + " | " + nombre);
            }

        } catch (Exception e) {
            System.out.println("Error al listar los datos: " + e.getMessage());
        }
    }
}
