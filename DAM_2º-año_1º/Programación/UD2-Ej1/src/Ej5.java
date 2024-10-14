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




    }
}
