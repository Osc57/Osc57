package Ej2;
/*
2. Crea un programa que elija al azar 3 números distintos entre 0 y 9.
*/

import java.util.ArrayList;
import java.util.Random;

public class Ej2 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> listaRandoms = new ArrayList<>();

        while (listaRandoms.size() < 3) {
            int n = random.nextInt(10);

            if (!listaRandoms.contains(n)) {
                listaRandoms.add(n);
            }
        }

        System.out.println("Números: " + listaRandoms);

    }
}
