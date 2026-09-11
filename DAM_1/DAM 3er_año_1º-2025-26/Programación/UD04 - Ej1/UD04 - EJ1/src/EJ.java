import java.util.Scanner;

public class EJ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean enteroValido;

        do {
            System.out.print("Dime un número entero: ");
            if (scanner.hasNextInt()) {
                int entero = scanner.nextInt();
                scanner.nextLine();
                enteroValido = true;

                boolean seguirLeyendoReal;
                do {
                    System.out.print("Dime un número real: ");
                    if (scanner.hasNextDouble()) {
                        double real = scanner.nextDouble();
                        System.out.println("Suma -> " + (entero + real));
                        seguirLeyendoReal = true;
                    } else {
                        scanner.nextLine();
                        System.out.println("ERROR: Introduce un número real");
                        seguirLeyendoReal = false;
                    }
                } while (!seguirLeyendoReal);

            } else {
                scanner.nextLine();
                System.out.println("ERROR: Introduce un número real");
                enteroValido = false;
            }
        } while (!enteroValido);

          /*
        if (scanner.hasNextInt()) {
            int entero = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Dime ahora un número real: ");

            if (scanner.hasNextDouble()) {
                double real = scanner.nextDouble();

                System.out.println(entero + real);

            } else {
                System.out.println("ERROR: Introduce un número real");
            }

        } else {
            System.out.println("ERROR: Introduce un número entero");
        }
        */
    }
}
