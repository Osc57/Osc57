/*
33. Realiza un programa que pida introducir un número entero por la consola.
Después deberá mostrar la descomposición del número en factores primos.
Ejemplo:
24 | 2
12 | 2
6 | 2
3 | 3
1
Tips:
• Representa el diagrama de flujo de los programas antes de
desarrollarlos
• El operador módulo % que calcula el resto sirve para evaluar si un
número es divisor. El resto de la división es cero si el dividendo es
múltiplo del divisor.
• Para evaluar los posibles divisores de un número n basta con evaluar
divisores hasta n/2, ya que no puede tener divisores mayores que su
mitad.
*/

import java.util.Scanner;

public class Ej33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            for (int i = 2; i <= n; i++) {
                while (n % i == 0) {
                    System.out.println(n + "|" + i);
                    n = n / i;
                }
            }

            if (n > 1) {
                System.out.println(n + "|" + n);
            }
            System.out.println(1);

        } else {
            System.out.println("Debe introducir un número entero (0-9)");
        }
    }
}










