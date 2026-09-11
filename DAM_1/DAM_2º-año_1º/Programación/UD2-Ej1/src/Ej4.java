import java.util.Scanner;

/**
 * Realiza un programa que pida al usuario introducir un número y devuelva su raíz
 * cuadrada. Ayuda: la clase Math tiene una función (sqrt) que calcula la raíz cuadrada.
 * **/
public class Ej4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número para darte su raíz: ");
        int numero = scanner.nextInt();

        double raiz = Math.sqrt(numero);

        System.out.println("La raíz de " + numero + " es: " + raiz);
    }
}
