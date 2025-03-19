package org.example.Ej5;

import org.example.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Ej5 extends Conexion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce datos para editar a los alumnos");
        System.out.print("Introduce el id del alumno: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduce el nombre del alumno: ");
        String nombre = scanner.nextLine();

        System.out.print("Introduce el apellido del alumno: ");
        String apellido = scanner.nextLine();

        System.out.print("Y ahora introduce su dirección: ");
        String direccion = scanner.nextLine();

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE alumno SET nombre=?, apellidos=?, direccion=? WHERE id=?")) {


            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, direccion);
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();

            System.out.println("Datos actualizados correctamente");
        } catch (Exception e) {
            System.out.println("Error en la actualización de los datos: " + e.getMessage());
        }
    }
}
