package Ejercicios_Streams.Ej4;

/*
Ejercicio 4:
Crea la clase persona con al menos los atributos nombre y edad.
- Ordenar una lista de personas por edad de forma descendente
- Imprimimos la lista de personas ordenada por nombre de forma ascendente
*/

import java.util.Comparator;
import java.util.List;

public class Ej4 {
    static void main() {
        List<Persona> personas = List.of(
                new Persona("Manuel", 34),
                new Persona("Alberto", 23),
                new Persona("Javier", 18),
                new Persona("Maria", 56),
                new Persona("Jose Javier", 87));

        List<Persona> personasPorEdad = personas.stream()
                .sorted(Comparator.comparingInt(Persona::getEdad).reversed())
                .toList();

        System.out.println("---------------- Ordenadas por edad descencente ----------------");
        personasPorEdad.forEach(System.out::println);

        List<Persona> personasPorNombre = personas.stream()
                .sorted(Comparator.comparing(Persona::getNombre))
                .toList();

        System.out.println("---------------- Ordenadas por nombre ascendente ----------------");
        personasPorNombre.forEach(System.out::println);
    }
}
