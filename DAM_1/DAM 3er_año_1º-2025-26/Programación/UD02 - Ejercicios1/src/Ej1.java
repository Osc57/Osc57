/*
1. Realiza un programa que pida al usuario introducir los lados de un rectángulo y calcule
su área.
*/

import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime la base de tu rectangulo: ");
        int base = scanner.nextInt();

        System.out.println("Dime la altura de tu rectangulo: ");
        int altura = scanner.nextInt();


        System.out.println("El área del rectangulo es: " + base * altura);
    }
}
