package org.example.Ej8;

import org.example.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Añade a tu interfaz un método que te permita:
 * <p>
 *  Buscar por Id.
 *  Buscar por Nombre, buscar por apellidos,
 *  Buscar conjuntamente por nombre y por apellidos, permitiendo la búsqueda
 * incompleta en ambos casos, si queremos buscar Antonio López, el programa
 * debe ser capaz de encontrarlo si le pasamos ‘An’ como nombre y ‘L’ como
 * apellidos, o incluso ‘ni’ como nombre y ‘pe’ como apellidos
 */

public class Ej8 extends Conexion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Presione el número en su teclado según la función que vaya a realizar");
        System.out.println("1 - Para buscar el alumno por id");
        System.out.println("2 - Para buscar el alumno por nombre y por apellido");
        System.out.println("3 - Para buscar por nombre y por apellido pero este puede estar incompleto");
        System.out.print("Introduce la función que desee realizar: ");
        int funcion = scanner.nextInt();

        switch (funcion) {
            case 1:
                System.out.print("Faciliteme el id del alumno el cuál quiera buscar: ");
                int id = scanner.nextInt();

                try (Connection connection = connect();
                     PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM alumno WHERE id=?;")) {

                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        int idAl = resultSet.getInt("id");
                        String nombre = resultSet.getString("nombre");
                        String apellido = resultSet.getString("apellidos");
                        String direccion = resultSet.getString("direccion");

                        System.out.println(idAl + " | " + nombre + " | " + apellido + " | " + direccion);
                        System.out.println();
                    }

                } catch (Exception e) {
                    System.out.println("Error al ejecutar el listado del alumno: " + e.getMessage());
                }finally {
                    scanner.close();
                }
            case 2:
                System.out.print("Faciliteme el nombre del alumno: ");
                String nombre = scanner.nextLine();
                scanner.nextLine();

                System.out.print("Faciliteme ahora el apellido: ");
                String apellido = scanner.nextLine();

                try (Connection connection = connect();
                     PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM alumno WHERE nombre=? OR apellidos=?;")) {

                    preparedStatement.setString(1, nombre);
                    preparedStatement.setString(2, apellido);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        int idAl = resultSet.getInt("id");
                        String nombreAl = resultSet.getString("nombre");
                        String apellidoAl = resultSet.getString("apellidos");
                        String direccionAl = resultSet.getString("direccion");

                        System.out.println(idAl + " | " + nombreAl + " | " + apellidoAl + " | " + direccionAl);
                        System.out.println();
                    }

                } catch (Exception e) {
                    System.out.println("Error al ejecutar el listado del alumno: " + e.getMessage());
                }finally {
                    scanner.close();
                }
            case 3:
                System.out.print("Faciliteme el nombre del alumno: ");
                String nombre1 = scanner.nextLine();
                scanner.nextLine();

                System.out.print("Faciliteme ahora el apellido: ");
                String apellido1 = scanner.nextLine();

                try (Connection connection = connect();
                     PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM alumno WHERE nombre LIKE ? AND apellidos LIKE ?;")) {

                    preparedStatement.setString(1,"%" +  nombre1 + "%");
                    preparedStatement.setString(2, "%" + apellido1 + "%");
                    ResultSet resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        int idAl = resultSet.getInt("id");
                        String nombreAl = resultSet.getString("nombre");
                        String apellidoAl = resultSet.getString("apellidos");
                        String direccionAl = resultSet.getString("direccion");

                        System.out.println(idAl + " | " + nombreAl + " | " + apellidoAl + " | " + direccionAl);
                        System.out.println();
                    }

                } catch (Exception e) {
                    System.out.println("Error al ejecutar el listado del alumno: " + e.getMessage());
                }finally {
                    scanner.close();
                }

        }
    }
}
