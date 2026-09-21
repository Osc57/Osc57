package Ejercicios;

/*
4) Generar una secuencia de números aleatorios: Utiliza un “Supplier” para generar e
imprimir una secuencia de diez números aleatorios.
*/

import java.util.Random;
import java.util.function.Supplier;

public class Ej4 {
    static void main() {
        Random r = new Random();

        Supplier<Integer> randoms = () -> r.nextInt(100 + 1);

        for (int i = 0; i < 10; i++) {
            System.out.print(randoms.get() + " ");
        }

    }
}
