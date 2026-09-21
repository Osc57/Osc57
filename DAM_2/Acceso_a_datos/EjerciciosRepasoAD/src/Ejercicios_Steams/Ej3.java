package Ejercicios_Steams;

/*
Ejercicio 3:
Crea una lista de números.
Usando stream, calcula la suma de los cuadrados de todos los números de la lista.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej3 {
    static void main() {
        List<Integer> listaEnteros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

        listaEnteros.stream().map(n -> n + Math.pow(n, 2)).forEach(System.out::println);
    }
}
