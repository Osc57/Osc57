package Practica;

import java.util.Arrays;
import java.util.List;

public class Main {
    static void main() {
        calculaCuadrados();
    }

    public static void calculaCuadrados() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Primero filtro para ver números pares
        List<Integer> cuadradosPares = numbers.stream().filter(n -> n % 2 == 0).toList();

        System.out.println(cuadradosPares);
    }
}
