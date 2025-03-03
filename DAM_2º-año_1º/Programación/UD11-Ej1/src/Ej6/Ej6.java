package Ej6;

import java.util.*;

/**
 *Escribe un programa que crear una lista de 30 números aleatorios entre 0 y 99. A
 * continuación, el programa mostrará todos los números, pero sin elementos
 * repetidos en caso de que los hubiera.
 * **/

public class Ej6 {
    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> numeros = new HashSet<>();


        while (numeros.size() < 30) {
            int numero = random.nextInt(100);
            numeros.add(numero);
        }

        System.out.println(numeros);
        
    }
}
