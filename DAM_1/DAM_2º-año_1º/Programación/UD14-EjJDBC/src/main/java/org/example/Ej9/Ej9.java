package org.example.Ej9;

import org.example.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Ej9 extends Conexion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vamos a ingresar un alumno a un curso");
        System.out.print("Dime el id del alumno: ");
        int id = scanner.nextInt();

        System.out.print("");


        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("")){


        } catch (Exception e) {
            System.out.println("Error al listar los datos: " + e.getMessage());
        }
    }
}
