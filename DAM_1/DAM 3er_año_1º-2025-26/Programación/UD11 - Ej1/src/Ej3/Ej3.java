package Ej3;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/*
3. Crea un programa que elija al azar 50 números entre 0 y 99. Después el programa
pedirá al usuario introducir un número entre 0 y 99 y le dirá cuántas veces aparece
dicho número en la lista.
*/
public class Ej3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 50; i++) {
            int num = random.nextInt(100);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.print("Introduce un número entre 0 y 99: ");
        int buscado = scanner.nextInt();

        int total = map.getOrDefault(buscado, 0);

        System.out.println("El número " + buscado + " aparece " + total + " veces.");

    }
}
