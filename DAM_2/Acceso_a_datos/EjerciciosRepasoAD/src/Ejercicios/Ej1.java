package Ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
1) Filtrar números impares: Crea una lista de números enteros. Utiliza un “Predicate”
para filtrar la lista y eliminar todos los números impares.
*/

public class Ej1 {
    static void main() {
        Predicate<Integer> isOdd = n -> n % 2 != 0;
        List<Integer> listaEnteros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));


        listaEnteros.removeIf(isOdd);

        System.out.println(listaEnteros);
    }
}
