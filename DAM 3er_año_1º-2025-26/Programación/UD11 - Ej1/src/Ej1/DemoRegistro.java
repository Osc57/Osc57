package Ej1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class DemoRegistro {
    public static void main(String[] args) {
        String archivo = "DATA.csv";
        List<Registro> registros = new ArrayList<>();

        try {
            registros = Files.lines(Paths.get(archivo))
                    .skip(1) // Omitir cabecera
                    .map(linea -> {
                        String[] d = linea.split(",");
                        return new Registro(d[1], d[2], d[6], d[7], d[9]);
                    })
                    .collect(Collectors.toList());
            procesarDatos(registros);

        } catch (IOException e) {
            System.err.println("Error al leer DATA.csv: " + e.getMessage());
        }
    }

    private static void procesarDatos(List<Registro> lista) {
        System.out.println("\n--- REGISTROS DE FRANCIA (FR) ---");
        lista.stream()
                .filter(r -> r.getCountry().equals("FR"))
                .forEach(System.out::println);

        System.out.println("\n--- YAHOO ORDENADOS POR NOMBRE ---");
        lista.stream()
                .filter(r -> r.getEmail().contains("yahoo"))
                .sorted(Comparator.comparing(Registro::getFirstName))
                .forEach(System.out::println);

        System.out.println("\n--- LOGIN NOV-2015 A ENE-2017 (DESC) ---");
        LocalDateTime inicio = LocalDateTime.of(2015, 11, 1, 0, 0);
        LocalDateTime fin = LocalDateTime.of(2017, 1, 31, 23, 59);
        lista.stream()
                .filter(r -> !r.getLastLogin().isBefore(inicio) && !r.getLastLogin().isAfter(fin))
                .sorted(Comparator.comparing(Registro::getLastLogin).reversed())
                .forEach(System.out::println);

        System.out.println("\n--- NOMBRES CON 'A' (ORDEN LOGIN DESC) ---");
        lista.stream()
                .filter(r -> r.getFirstName().startsWith("A"))
                .sorted(Comparator.comparing(Registro::getLastLogin).reversed())
                .forEach(r -> System.out.println(r.getFirstName() + " " + r.getLastName()));
    }
}

