/*
4. Realiza un programa que pida al usuario introducir un número y devuelva su raíz
cuadrada. Ayuda: la clase Math tiene una función (sqrt) que calcula la raíz cuadrada.
* */

import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int n = scanner.nextInt();

        int raiz = (int) Math.sqrt(n);

        System.out.println("La raíz de " + n + " es " + raiz);
    }
}
