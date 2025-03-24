package org.example.Ej11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static org.example.Conexion.connect;

/**
 * Realiza un programa que permita matricular a un alumno en un curso. Como es lógico
 * un alumno no puede matricularse dos veces en el mismo curso.
 **/

public class Ej11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vamos a matricular a un alumno en un curso");
        System.out.print("Digame el id de el alumno: ");
        int idAlumno = scanner.nextInt();

        System.out.print("Digame el id del curso: ");
        int idCurso = scanner.nextInt();

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO matriculado (id_alumno, id_curso) VALUES (?,?);")) {

            preparedStatement.setInt(1, idAlumno);
            preparedStatement.setInt(2, idCurso);

            preparedStatement.executeUpdate();

            System.out.println("Alumno insertado correctamente");

        } catch (Exception e) {
            System.out.println("Error al insertar el alumno al curso: " + e.getMessage());
        }
    }
}
