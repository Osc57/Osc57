/*
14. Realiza una función recursiva que dado un número entero calcule la suma de
todas sus cifras.
*/

import java.util.Scanner;

public class Ej14 {
    public static int sumaRecursivaDigitos(int n) {
        if (n == 0) {
            return 0;
        } else {
            return (n % 10) + sumaRecursivaDigitos(n / 10);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número y sumare sus cifras: ");

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(sumaRecursivaDigitos(n));
        } else {
            System.out.println("ERROR: Introduce un número entero");
        }

    }
}
