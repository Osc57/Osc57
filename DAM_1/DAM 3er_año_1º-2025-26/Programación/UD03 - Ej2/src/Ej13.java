/*
13. Crear un programa calcule cuantas cifras tiene un número entero positivo
(pista: se puede hacer dividiendo varias veces entre 10).
*/

import java.util.Scanner;

public class Ej13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int digitos = 0;
        System.out.print("Dime un número entero: ");
        int n1 = scanner.nextInt();

        while (n1 > 0) {
            n1 = n1 / 10;
            digitos++;
        }
        System.out.println("Los digitos que tiene el número son: " + digitos);
    }
}
