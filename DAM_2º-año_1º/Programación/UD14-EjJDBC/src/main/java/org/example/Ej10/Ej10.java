package org.example.Ej10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static org.example.Conexion.connect;

/**
 * Realiza un CRUD respecto a los cursos, para poder incluir, borrar, editar y listarlos.
 **/
public class Ej10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Presione el número en su teclado según la función que vaya a realizar");
        System.out.println("1 - Para insertar un curso nuevo");
        System.out.println("2 - Para borrar un curso");
        System.out.println("3 - Para editar un curso");
        System.out.println("4 - Para mostrar los cursos");
        System.out.println("0 - Para salir y no realizar ninguna función");
        System.out.print("Introduce la función que desee realizar: ");
        int funcion = scanner.nextInt();
        scanner.nextLine();

        switch (funcion) {
            case 1:
                System.out.print("Faciliteme el nombre del curso: ");
                String nombreCurso = scanner.nextLine();

                System.out.print("Faciliteme el nombre del instructor que imparte el curso: ");
                String nombreInstructor = scanner.nextLine();

                try (Connection connection = connect();
                     PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cursos (nombre, instructor) VALUES (?,?);");) {

                    preparedStatement.setString(1, nombreCurso);
                    preparedStatement.setString(2, nombreInstructor);

                    preparedStatement.executeUpdate();

                    System.out.println("Curso insertado correctamente");

                } catch (Exception e) {
                    System.out.println("Error al insertar el curso: " + e.getMessage());
                }
                break;
            case 2:
                System.out.print("Faciliteme el id del curos que desee borrar: ");
                int id = scanner.nextInt();

                try (Connection connection = connect();
                     PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cursos WHERE id=?")) {

                    preparedStatement.setInt(1, id);

                    preparedStatement.executeUpdate();
                    System.out.println("Curso eliminado correctamente");

                } catch (Exception e) {
                    System.out.println("Error al eliminar el curso: " + e.getMessage());
                }
                break;
            case 3:
                System.out.print("Faciliteme el id del curso que desee actualizar: ");
                int idC = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Faciliteme el nombre del curso: ");
                String nombre1 = scanner.nextLine();

                System.out.print("Faciliteme ahora el instructor: ");
                String instructor1 = scanner.nextLine();

                try (Connection connection = connect();
                     PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cursos SET nombre=? AND instructor=? WHERE id=?")) {

                    preparedStatement.setString(1, nombre1);
                    preparedStatement.setString(2, instructor1);
                    preparedStatement.setInt(3,idC);

                    preparedStatement.executeUpdate();
                    System.out.println("Curso actualizado correctamente");

                } catch (Exception e) {
                    System.out.println("Error al ejecutar el listado del alumno: " + e.getMessage());
                }
                break;
            case 4:
                break;
            case 0:
                break;
        }

    }
}
