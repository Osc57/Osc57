package Ejercicios;


/*
5) Filtrar nombres que comienzan con una letra específica: Crea una lista de
nombres. Utiliza un “Predicate” para filtrar la lista y mantener solo los nombres
que comienzan con una letra específica (por ejemplo, "A").
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Ej5 {
    static void main() {
        List<String> lista = new ArrayList<>(Arrays.asList("Ana", "Lucia", "Marcos", "Andrea", "Monica"));

        Predicate<String> predicate = l -> !l.startsWith("A");

        lista.removeIf(predicate);

        System.out.println(lista);

    }
}
