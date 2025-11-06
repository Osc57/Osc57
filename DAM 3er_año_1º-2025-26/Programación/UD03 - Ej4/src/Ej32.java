/*
32. Realiza un programa que pida introducir un número entero por la consola.
Después deberá mostrar los divisores enteros del número.
Ejemplo: 24 → 2, 3, 4, 6, 8, 12
*/

import java.util.Scanner;

public class Ej32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    System.out.println(i + " ");
                }
            }

        } else {
            System.out.println("Debe introducir un número entero (0-9)");
        }

    }
}
