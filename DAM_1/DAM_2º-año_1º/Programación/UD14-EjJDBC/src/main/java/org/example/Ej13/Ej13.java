package org.example.Ej13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import static org.example.Conexion.connect;

/**
 * Realiza un programa que permita modificar la matricula de un alumno y un curso. Es
 * decir Juan estaba matriculado en el curso de matemática, y ahora Juan va a estar
 * matriculado en el curso de Física
 **/

public class Ej13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vamos a modificar la matricula del alumno en un curso");
        System.out.print("Digame el id de el alumno: ");
        int idAlumno = scanner.nextInt();

        System.out.print("Digame el nombre del curso: ");
        String nombreCurso = scanner.nextLine();

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE matriculado SET id_curso = (SELECT id FROM cursos WHERE nombre=?) WHERE id_alumno=?;")) {

            preparedStatement.setString(1, nombreCurso);
            preparedStatement.setInt(2, idAlumno);

            preparedStatement.executeUpdate();

            System.out.println("Alumno cambiado correctamente");

        } catch (Exception e) {
            System.out.println("No se puede introducir el alumno en un curso en el que ya esta: " + e.getMessage());
        }
    }
}
