package Ej1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

public class DemoRegistro {
    public static void main(String[] args) {
        try {
            List<Registro> registros = Files.lines(Paths.get("DATA.csv")).skip(1).map(linea -> new Registro(linea.split(","))).toList();

            System.out.println("\n--- País: FR ---");
            registros.stream().filter(r -> r.getCountry().equals("FR")).forEach(System.out::println);

            System.out.println("\n--- Yahoo (Orden Nombre) ---");
            registros.stream().filter(r -> r.getEmail().contains("yahoo")).sorted(Comparator.comparing(Registro::getFirstName)).forEach(System.out::println);

            System.out.println("\n--- Login Nov15-Ene17 (Desc) ---");
            LocalDateTime inicio = LocalDateTime.of(2015, 11, 1, 0, 0);
            LocalDateTime fin = LocalDateTime.of(2017, 1, 31, 23, 59);

            registros.stream().filter(r -> !r.getLastLogin().isBefore(inicio) && !r.getLastLogin().isAfter(fin)).sorted(Comparator.comparing(Registro::getLastLogin).reversed()).forEach(System.out::println);

            System.out.println("\n--- Empiezan por 'A' (Orden Fecha Desc) ---");
            registros.stream().filter(r -> r.getFirstName().startsWith("A")).sorted(Comparator.comparing(Registro::getLastLogin).reversed()).forEach(r -> System.out.println(r.getFirstName() + " " + r.getLastName()));
        } catch (IOException e) {
            System.out.println("Error: Asegúrate de que DATA.csv esté en la carpeta del proyecto.");
        }
    }
}

