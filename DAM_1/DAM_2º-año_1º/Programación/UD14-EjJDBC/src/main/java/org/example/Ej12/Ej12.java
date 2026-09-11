package org.example.Ej12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import static org.example.Conexion.connect;

/**
 * Realiza un programa que permita desmatricular a un alumno de un curso al que se
 * encuentra matriculado.
 **/

public class Ej12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vamos a desmatricular a un alumno de un curso");
        System.out.print("Digame el id de el alumno: ");
        int idAlumno = scanner.nextInt();

        System.out.print("Digame el id del curso: ");
        int idCurso = scanner.nextInt();

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM matriculado WHERE id_alumno=? AND id_curso=?;")) {

            preparedStatement.setInt(1, idAlumno);
            preparedStatement.setInt(2, idCurso);

            preparedStatement.executeUpdate();

            System.out.println("Alumno desmatriculado correctamente");

        } catch (Exception e) {
            System.out.println("Error al desmatricular el alumno del curso: " + e.getMessage());
        }
    }
}
