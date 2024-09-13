
import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime la base de tu rectángulo: ");
        int base = scanner.nextInt();
        System.out.print("Dime el lado de tu rectángulo: ");
        int altura = scanner.nextInt();

        int area = base * altura;

        System.out.print("El área de tu rectángulo es: " + area);

        scanner.close();
    }
}