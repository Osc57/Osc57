package Ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
6) Aplicar una operación a cada elemento de una lista: Crea una lista de números
enteros. Utiliza un “Consumer” para aplicar una operación a cada número en la
lista (por ejemplo, multiplicar cada número por 2).
*/

public class Ej6 {
    static void main() {
        List<Integer> listaEnteros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

        Consumer<Integer> consumer = n -> System.out.print(n * 2 + " ");


        listaEnteros.forEach(consumer);
    }
}
