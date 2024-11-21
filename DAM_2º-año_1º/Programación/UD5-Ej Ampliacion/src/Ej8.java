import java.util.Scanner;

/**
 * Desarrolla un programa que pida al usuario introducir un número entero. El
 * programa mostrará si el número es o no capicúa (para los números negativos
 * debe ignorar el signo).
 **/
public class Ej8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dime un número: ");
        int numero = scanner.nextInt();

        if (numero < 0) {
            numero = numero * -1;
        }

        StringBuilder num =  new StringBuilder(numero);

        


    }
}
