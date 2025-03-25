package org.example.Ej14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static org.example.Conexion.connect;

/**
 * Realiza un programa que nos pregunte por un alumno, y nos devuelva un listado de
 * cursos a los que se encuentra matriculado.
 **/

public class Ej14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vamos a buscar a que cursos esta matricualdo un alumno");
        System.out.print("Proporcioneme su id: ");
        int idAl = scanner.nextInt();
        scanner.nextLine();

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT cursos.nombre FROM matriculado INNER JOIN cursos ON matriculado.id_curso=cursos.id WHERE matriculado.id_alumno=?;")) {

            preparedStatement.setInt(1, idAl);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String nombre = resultSet.getString("nombre");

                System.out.println(nombre);
            }

        } catch (Exception e) {
            System.out.println("Error al listar los datos: " + e.getMessage());
        }
    }
}
