import java.util.Random;
import java.util.Scanner;

/**
 * El método ramdom de la clase Math devuelve números reales aleatorios entre 0 y 1.
 *      a. Basándote en este comportamiento crea un programa que devuelva un
 *      número entero aleatorio entero entre 0 y 100.
 *      b. Modifica el programa para pedir al usuario un número entero positivo y el
 *      programa devuelva tres números enteros aleatorios entre 0 y el número
 *      elegido por el usuario.
 *      c. Modifica el programa para pedir al usuario dos números enteros positivos y el
 *      programa devuelva tres números enteros aleatorios entre los dos números
 *      elegidos por el usuario.
 * **/
public class Ej5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int aleatorio = (int) (Math.random()*100);
        System.out.println("Número aleatorio entre 1 y 100: " + aleatorio);

        System.out.print("Dime un número: ");
        int numero = scanner.nextInt();

        int aleatorio2 = (int)(Math.random()*numero);
        int aleatorio3 = (int)(Math.random()*numero);
        int aleatorio4 = (int)(Math.random()*numero);
        System.out.println("Número aleatorio entre 0 y el número elegido: " + aleatorio2);
        System.out.println("Número aleatorio entre 0 y el número elegido: " + aleatorio3);
        System.out.println("Número aleatorio entre 0 y el número elegido: " + aleatorio4);

        System.out.print("Dime un número: ");
        int n1 = scanner.nextInt();

        System.out.print("Dime otro número: ");
        int n2 = scanner.nextInt();

        int valorEntero1 = (int) (Math.floor(Math.random()*(n1-n2+1)+n2));
        int valorEntero2 = (int) (Math.floor(Math.random()*(n1-n2+1)+n2));
        int valorEntero3 = (int) (Math.floor(Math.random()*(n1-n2+1)+n2));

        System.out.println("Número entero aleatorio entre " + n1 + " y " + n2 + ": " + valorEntero1);
        System.out.println("Número entero aleatorio entre " + n1 + " y " + n2 + ": " + valorEntero2);
        System.out.println("Número entero aleatorio entre " + n1 + " y " + n2 + ": " + valorEntero3);

        scanner.close();

    }
}
