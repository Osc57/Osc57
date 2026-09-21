package Ejercicios;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*
3) Transformar una lista de números: Crea una lista de números enteros. Utiliza una
“Function” para transformar cada número en la lista a su cubo.
*/


public class Ej3 {
    static void main() {
        List<Integer> listaEnteros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

        Function<Integer, Integer> cubo = x -> (int) Math.pow(x, 3);

        List<Integer> listaCubos = listaEnteros.stream().map(cubo).toList();


        System.out.println(listaEnteros);
        System.out.println(listaCubos);
    }
}
