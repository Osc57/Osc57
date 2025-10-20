/*
9. Realiza un programa que pida al usuario introducir dos números y muestre el resultado
de elevar el primero al segundo.
* */

import java.util.Scanner;

public class Ej9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int n1 = scanner.nextInt();

        System.out.print("Dime otro número: ");
        int n2 = scanner.nextInt();

        int elevado = (int) Math.pow(n1, n2);

        System.out.println("Resultado de elevar " + n1 + " a la " + n2 + " es " + elevado);

    }
}
