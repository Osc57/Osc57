/*
11. Crea un programa que genere un array de 10 números aleatorios entre -10 y
10 de manera que no haya elementos repetidos. El programa mostrará los
números contenidos en el array.
*/

import java.util.Arrays;

public class Ej11 {
    public static void main(String[] args) {
        int[] numAleatorios = new int[10];
        int contador = 0;

        while (contador < numAleatorios.length) {
            int aleatorios = (int) (Math.random() * 21) - 10;

            int i;
            for (i = 0; i < contador; i++) {
                if (numAleatorios[i] == aleatorios) {
                    break;
                }
            }

            if (i == contador) {
                numAleatorios[contador] = aleatorios;
                contador++;
            }
        }
        System.out.println("Array donde no hay repetidos: " + Arrays.toString(numAleatorios));
    }
}
