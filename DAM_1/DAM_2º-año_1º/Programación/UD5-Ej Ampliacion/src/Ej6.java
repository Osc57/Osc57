import java.util.Scanner;

/**
 * Desarrolla un programa que pida al usuario introducir su nombre. El programa
 * saludará al usuario escribiendo “Hola “ + <su nombre>. En el caso de que el
 * nombre sea compuesto el programa saludará escribiendo únicamente el
 * primer nombre. Por ejemplo, si el nombre introducido por el usuario es “John
 * Fitzgerald” el programa escribirá “Hola John”.
 **/
public class Ej6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime tu nombre: ");
        String nombre = scanner.nextLine();

        int primerNombre = nombre.indexOf(" ");

        if (primerNombre > 0) {
            String n = nombre.substring(0, primerNombre);
            System.out.println("Hola " + n);
        }

    }
}
