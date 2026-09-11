/*
31. Realiza un programa que genere y muestre por pantalla 10 números
aleatorios entre 1 y 100. Después el programa debe mostrar el número
máximo y mínimo de la serie.
*/

import java.util.Random;

public class Ej31 {
    public static void main(String[] args) {
        Random random = new Random();
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            int aleatorio = random.nextInt(0, 100);
            System.out.print(aleatorio + " ");

            if (aleatorio > maximo) {
                maximo = aleatorio;
            }

            if (aleatorio < minimo) {
                minimo = aleatorio;
            }
        }

        System.out.println();
        System.out.println("Número maximo: " + maximo);
        System.out.println("Número minimo: " + minimo);


    }
}
