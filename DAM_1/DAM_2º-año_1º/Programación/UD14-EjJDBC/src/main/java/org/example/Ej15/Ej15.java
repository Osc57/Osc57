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

        System.out.println("Vamos a ver los alumnos matriculados en el curso");
        System.out.print("Dime el id de la asignatura: ");
        int idAsign = scanner.nextInt();
        scanner.nextLine();

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT alumno.nombre, alumno.apellidos FROM alumno INNER JOIN matriculado ON alumno.id=matriculado.id_alumno INNER JOIN cursos ON matriculado.id_curso=cursos.id WHERE matriculado.id_curso=?;")) {

            preparedStatement.setInt(1,idAsign);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");

                System.out.println(nombre + " | " + apellidos);
            }

        } catch (Exception e) {
            System.out.println("Error al listar los datos: " + e.getMessage());
        }


    }
}
