/*
8. Crear una función que calcule el mayor de dos números enteros que recibirá
como parámetros. El resultado será otro número entero. Desarrolla otra
implementación que reciba 2 números reales y devuelva un número real
(double).
*/

import java.util.Scanner;

public class Ej8 {
    public static int mayorEntero(int n1, int n2) {
        return Math.max(n1, n2);
    }

    public static double mayorReal(double n1, double n2) {
        return Math.max(n1, n2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número entero: ");
        int n1 = scanner.nextInt();

        System.out.print("Dime otro número entero: ");
        int n2 = scanner.nextInt();

        System.out.println("Mayor de los enteros: " + mayorEntero(n1, n2));

        System.out.print("Dime un número real: ");
        double num1 = scanner.nextDouble();

        System.out.print("Dime otro número real: ");
        double num2 = scanner.nextDouble();

        System.out.println("Mayor de los reales: " + mayorReal(num1, num2));

    }
}
