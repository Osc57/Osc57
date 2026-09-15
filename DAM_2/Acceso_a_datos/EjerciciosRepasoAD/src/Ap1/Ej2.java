package Ap1;

import java.util.ArrayList;
import java.util.Arrays;

/*
Ej2. Dada una lista de números enteros, escribir una función que devuelva una
nueva lista que contenga solo los números pares de la lista original.
*/

public class Ej2 {
    static void main() {
        ArrayList<Integer> intArray = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        System.out.print(oddsFunction(intArray));

    }

    static ArrayList<Integer> oddsFunction(ArrayList<Integer> list) {
        ArrayList<Integer> oddList = new ArrayList<>();

        for (Integer i : list) {
            if (i % 2 == 0) {
                oddList.add(i);
            }
        }

        return oddList;
    }
}
