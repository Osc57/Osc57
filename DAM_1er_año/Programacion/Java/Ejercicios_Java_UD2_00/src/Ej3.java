import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime tu edad: ");
        int edad = scanner.nextInt();

        System.out.print("Dime tu peso(en kg): ");
        double peso = scanner.nextDouble();

        System.out.print("Dime tu pulso: ");
        int pulso = scanner.nextInt();

        System.out.print("Dígame su plaquetas: ");
        double plaquetas = scanner.nextDouble();

        if (edad >= 18 && edad <= 65 && peso >= 50 && peso <= 100 && pulso >= 50 && pulso <= 110 && plaquetas >= 150000) {
            System.out.print("Puedes donar sangre.");
        } else {
            System.out.print("No puedes donar sangre.");
        }

        scanner.close();

    }
}
