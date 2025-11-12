/*
9. Crea una función que realice una cuenta atrás partiendo de un número entero
recibido como parámetro y utilizando recursividad.
*/

import java.util.Scanner;

public class Ej9 {
    public static int cuentaRegresiva(int n) {
        if (n <= 0) {
            return 0;
        }
        System.out.println(n);
        return cuentaRegresiva(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número para una cuenta regreseiva: ");

        if (scanner.hasNextInt()) {
            int n1 = scanner.nextInt();

            System.out.println(cuentaRegresiva(n1));
        }
    }
}
