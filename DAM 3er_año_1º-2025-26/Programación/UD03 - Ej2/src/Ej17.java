/*
17. Facturación.

a. Realiza un programa que pida introducir la facturación de una
empresa para los 12 meses del año y devuelva por pantalla el total
anual al finalizar.
b. Modifica el programa para que devuelva también la media.
c. Modifica el programa para que devuelva el mes con mayor
facturación y el valor de ésta.
d. Modifica el programa para que devuelva el mes con menor
facturación y el valor de ésta.
*/

import java.util.Scanner;

public class Ej17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int suma = 0;
        int contador = 0;
        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;

        for (int i = 0; i < 12; i++) {
            System.out.print("Dime cuanto has generado en el mes " + (i + 1) + ": ");

            suma += scanner.nextInt();
            contador++;
        }

        System.out.println("Total anual: " + suma);
        System.out.println("Media: " + suma / contador);
    }
}
