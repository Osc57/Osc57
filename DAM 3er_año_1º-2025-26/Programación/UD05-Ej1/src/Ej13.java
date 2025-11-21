/*
13. Crea un programa que pida al usuario introducir una lista de nombres;
primero pedirá cuantos nombres va a introducir, después pedirá introducir
esos nombres. Los datos se guardarán en un array. Después el programa
mostrará la lista ordenada por orden alfabético.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Ej13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean esNumero;

        do {
            System.out.print("Cuantos nombres vas a introducir: ");
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                String[] nombres = new String[n];

                for (int i = 0; i < nombres.length; i++) {
                    System.out.print("Vale, dime el " + (i + 1) + " nombre: ");
                    String nombre = scanner.next();
                    nombres[i] = nombre;
                }

                Arrays.sort(nombres);

                for (String name : nombres) {
                    System.out.print(name + " ");
                }
                esNumero = true;

            } else {
                System.out.println("No pasa nada, recuerda valores enteros (0-9)");
                scanner.next();
                esNumero = false;
            }
        } while (!esNumero);
    }
}
