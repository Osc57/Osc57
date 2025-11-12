import java.util.Scanner;

public class Ej1 {
    public static int signo(double n) {
        return (int) n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número real: ");

        if (scanner.hasNextDouble()) {
            double n1 = scanner.nextDouble();

            System.out.println("Te lo devuelvo entero: " + signo(n1));
        } else {
            System.out.println("Tiene que ser un número con decimales");
        }
    }
}
