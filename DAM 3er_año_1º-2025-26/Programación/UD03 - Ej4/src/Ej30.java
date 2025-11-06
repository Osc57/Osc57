/*
30. Crea un programa que "dibuje" un triángulo creciente, alineado a la derecha,
con la altura que indique el usuario. Por ejemplo, si el usuario dice que desea
4 caracteres de alto, el triángulo sería así:
*
**
***
****
*/

import java.util.Scanner;

public class Ej30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime la altura del triangulo creciente: ");

        if (scanner.hasNextInt()) {
            int altura = scanner.nextInt();

            for (int i = 1; i <= altura; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }

        } else {
            System.out.println("Debe introducir un número entero (0-9)");
        }
    }
}
