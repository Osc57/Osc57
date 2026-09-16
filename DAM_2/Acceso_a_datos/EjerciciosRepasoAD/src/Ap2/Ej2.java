package Ap2;

/*
Ej2. Dada una lista de números enteros, escribir una función que devuelva un
Set que contenga solo los números únicos de la lista original.
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ej2 {
    static void main() {
        List<Integer> numeros = List.of(1, 2, 3, 2, 4, 1, 5);
        Set<Integer> numerosUnicos = obtenerEnterosUnicos(numeros);
        System.out.println("Enteros únicos: " + numerosUnicos);
    }

    static Set<Integer> obtenerEnterosUnicos(List<Integer> lista) {
        if (lista == null) {
            return new HashSet<>();
        }
        return new HashSet<>(lista);
    }
}
