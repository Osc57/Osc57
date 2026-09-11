/*
13. Desarrolla una función que escriba la sucesión de Fibonacci hasta número de
secuencia dado.
*/

import java.util.Scanner;

public class Ej13 {
    public static int fibonacciHastaNumDado(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciHastaNumDado(n - 1) + fibonacciHastaNumDado(n - 2);

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");

        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();

            System.out.println(fibonacciHastaNumDado(num));

        } else {
            System.out.println("ERROR: Introduce un número entero");
        }

    }
}
