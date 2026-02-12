package Ej1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class EjercicioIA {
    public static void main(String[] args) {
        try {
            // Lectura y creación de la lista
            List<Registro> registros = Files.lines(Paths.get("DATA.csv"))
                    .skip(1)
                    .map(linea -> new Registro(linea.split(",")))
                    .collect(Collectors.toList());

            // --- EJERCICIOS CON STREAM().FILTER() ---

            // • Registros de Francia (FR)
            System.out.println("\n--- País: FR ---");
            registros.stream()
                    .filter(r -> r.country.equals("FR"))
                    .forEach(System.out::println);

            // • Email de yahoo ordenados por nombre
            System.out.println("\n--- Yahoo (Orden Nombre) ---");
            registros.stream()
                    .filter(r -> r.email.contains("yahoo"))
                    .sorted(Comparator.comparing(r -> r.firstName))
                    .forEach(System.out::println);

            // • Login entre Nov 2015 y Ene 2017 (Descendente)
            System.out.println("\n--- Login Nov15-Ene17 (Desc) ---");
            LocalDateTime inicio = LocalDateTime.of(2015, 11, 1, 0, 0);
            LocalDateTime fin = LocalDateTime.of(2017, 1, 31, 23, 59);

            registros.stream()
                    .filter(r -> !r.lastLogin.isBefore(inicio) && !r.lastLogin.isAfter(fin))
                    .sorted(Comparator.comparing((Registro r) -> r.lastLogin).reversed())
                    .forEach(System.out::println);

            // • Empiezan por 'A' ordenados por fecha desc (Solo nombre y apellido)
            System.out.println("\n--- Empiezan por 'A' (Orden Fecha Desc) ---");
            registros.stream()
                    .filter(r -> r.firstName.startsWith("A"))
                    .sorted(Comparator.comparing((Registro r) -> r.lastLogin).reversed())
                    .forEach(r -> System.out.println(r.firstName + " " + r.lastName));

        } catch (IOException e) {
            System.out.println("Error: Asegúrate de que DATA.csv esté en la carpeta del proyecto.");
        }
    }

