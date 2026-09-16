package Practica;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    static void main() {
        calculaCuadrados();
    }

    public static void calculaCuadrados() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Primero filtro para ver números pares
        Predicate<Integer> isEven = n -> n % 2 == 0;

        //List<Integer> cuadradosPares = numbers.stream().filter(n -> n % 2 == 0).toList();
        List<Integer> cuadradosPares = numbers.stream().filter(n -> n % 2 == 0)
                .map(n -> n * n).toList();

        System.out.println(cuadradosPares);

        List<Integer> numbers2 = Arrays.asList(2, 4, 6, 8, 10);

        System.out.println(numbers2.stream().allMatch(n -> n % 2 == 0));
    }
}
