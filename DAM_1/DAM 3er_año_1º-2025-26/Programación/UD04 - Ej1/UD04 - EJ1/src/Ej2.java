/*
2. Crear una función que calcule el menor de dos números enteros que recibirá
como parámetros. El resultado será otro número entero.
*/

import java.util.Scanner;

public class Ej2 {
    public static int menorDosNumeros(int n1, int n2) {
        return Math.min(n1, n2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Dime otro numero: ");
        int n1 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("El numero menor es: " + menorDosNumeros(n, n1));

    }
}
