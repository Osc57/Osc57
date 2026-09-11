import java.util.Scanner;

/**
 * Realiza un programa que pida al usuario introducir su nombre y después lo salude
 * usuario diciéndole “Hola” y su nombre.
 * **/
public class Ej2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime tu nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Hola " + nombre);
    }
}
