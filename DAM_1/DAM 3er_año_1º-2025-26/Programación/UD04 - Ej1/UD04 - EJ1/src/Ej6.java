/*
6. Crear una función que tenga como parámetros de entrada 2 números enteros
y como parámetro de salida un doble con la media aritmética de ambos.
*/

import java.util.Scanner;

public class Ej6 {
    public static double mediaAritmetica(int n1, int n2) {
        return (double) (n1 + n2) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int n1 = scanner.nextInt();

        System.out.print("Dime otro número: ");
        int n2 = scanner.nextInt();

        System.out.println(mediaAritmetica(n1, n2));
    }
}
