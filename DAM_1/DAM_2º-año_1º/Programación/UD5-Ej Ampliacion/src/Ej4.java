import java.util.Scanner;

/**
 * Desarrolla un programa que pida al usuario introducir números enteros de
 * manera indefinida hasta que el usuario introduzca dos veces seguidas el cero.
 * Al terminar el programa debe mostrar los dos mayores números introducidos.
 **/
public class Ej4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1, n2;
        int maximoN1 = -1;
        int maximoN2 = -1;


        do {
            System.out.print("Dime un número: ");
            n1 = scanner.nextInt();

            System.out.print("Dime otro número: ");
            n2 = scanner.nextInt();

            if (n1 != 0 || n2 != 0) {
                if (n1 > maximoN1) {
                    maximoN2 = maximoN1;
                    maximoN1 = n1;
                } else if (n1 > maximoN2) {
                    maximoN2 = n1;
                }

                if (n2 > maximoN1) {
                    maximoN2 = maximoN1;
                    maximoN1 = n2;
                } else if (n2 > maximoN2) {
                    maximoN2 = n2;
                }
            }

        } while (n1 != 0 || n2 != 0);

        System.out.println("Los dos números mayores fuerón: " + maximoN1 + " y " + maximoN2);
    }
}
