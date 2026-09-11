package org.example.Ej6;

import org.example.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * Realiza una pequeña interfaz que te permita borrar un estudiante existente.
 **/

public class Ej6 extends Conexion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce datos para eliminar a un alumno");
        System.out.print("Introduce el id del alumno que desea eliminar: ");
        int id = scanner.nextInt();

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM alumno WHERE id=?")) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            System.out.println("Alumno eliminado correctamente");
        } catch (Exception e) {
            System.out.println("Error en la eliminación del alumno: " + e.getMessage());
        }
    }
}
