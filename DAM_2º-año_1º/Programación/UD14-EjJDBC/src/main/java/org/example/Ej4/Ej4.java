package org.example.Ej4;

import org.example.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Realiza una pequeña interfaz que te permita insertar nuevos estudiantes
 **/

public class Ej4 extends Conexion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce los datos para insertar un alumno");
        System.out.print("Introduce el nombre del alumno: ");
        String nombre = scanner.nextLine();

        System.out.print("Introduce el apellido del alumno: ");
        String apellido = scanner.nextLine();

        System.out.print("Y ahora introduce su dirección: ");
        String direccion = scanner.nextLine();

        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO alumno (nombre,apellidos,direccion) VALUES (?,?,?)");

            preparedStatement.setString(1,nombre);
            preparedStatement.setString(2,apellido);
            preparedStatement.setString(3,direccion);

            preparedStatement.executeUpdate();

            System.out.println("Datos introducidos correctamente");
        } catch (Exception e) {
            System.out.println("Error en la inserción de los datos");
        } finally {
            try {
                connect().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
