import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Dígame su nombre: ");

        String nombre = scanner.nextLine();

        System.out.print("Hola " + nombre + " como estas");

        scanner.close();
    }
}
