import java.rmi.MarshalException;
import java.util.Scanner;

/**
 * Realiza un programa que pida al usuario introducir los lados de un rectángulo y calcule
 * su área.
 * **/
public class Ej1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime la base del rectángulo: ");
        int base = scanner.nextInt();

        System.out.print("Dime la altura del rectángulo: ");
        int altura = scanner.nextInt();

        int area = base*altura;

        System.out.println("El área del rectángulo es: " + area);

    }
}
