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
        int mesMayor = 0;
        int mesMenor = 0;

        for (int i = 0; i < 12; i++) {
            System.out.print("Dime cuanto has generado en el mes " + (i + 1) + ": ");

            if (scanner.hasNextInt()) {
                int facturacion = scanner.nextInt();
                scanner.nextLine();

                if (facturacion > 0) {
                    suma += facturacion;

                    if (facturacion > mayor) {
                        mayor = facturacion;
                        mesMayor = i + 1;
                    }

                    if (facturacion < menor) {
                        menor = facturacion;
                        mesMenor = i + 1;

                    }
                    contador++;
                } else {
                    System.out.println("ERROR: no puedes facturar 0 o menos");
                    i--;
                }


            } else {
                System.out.println("Introduce números enteros");
                scanner.next();
                i--;
            }


        }

        System.out.println("Total anual: " + suma + "€");
        System.out.println("Media: " + suma / contador + "€");
        System.out.println("El mes " + mesMayor + " ha facturado " + mayor + "€ ");
        System.out.println("El mes " + mesMenor + " ha facturado " + menor + "€ ");
    }
}
