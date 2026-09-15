package Ap2;

/*
Ej2. Dada una lista de números enteros, escribir una función que devuelva un
Set que contenga solo los números únicos de la lista original.
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ej2 {
    static void main() {
        Set<Integer> integerSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        System.out.print(integerSet);
    }
}
