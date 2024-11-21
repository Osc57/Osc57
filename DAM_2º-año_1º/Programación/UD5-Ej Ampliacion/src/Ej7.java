import java.util.Scanner;

/**
 * Desarrolla un programa que pida al usuario introducir números enteros de
 * manera indefinida hasta que el usuario introduzca un cero. Tras introducir
 * cada número el programa validará si el número es mayor que 1, en tal caso
 * mostrará si se trata o no de un número primo.
 **/
public class Ej7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Dime un número: ");
            numero = scanner.nextInt();

            if (numero >= 1) {
                if (numero % 2 == 0) {
                    System.out.println("Es primo: " + numero);
                } else {
                    System.out.println("No es primo: " + numero);
                }
            }

        } while (numero != 0);
    }
}
