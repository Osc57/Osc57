package Ej2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
/**
 * Crea un programa que elija al azar 3 números distintos entre 0 y 9.
 * **/
public class Ej2 {
    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> numeros = new HashSet<>();

        while (numeros.size() < 3){
            int numero = random.nextInt(10);
            numeros.add(numero);
        }

        System.out.println(numeros);
    }
}
