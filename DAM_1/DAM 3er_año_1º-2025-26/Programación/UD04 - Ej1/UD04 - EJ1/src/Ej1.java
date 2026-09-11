import java.util.Scanner;
/*
1. Crear una función llamada "signo", que reciba un número real, y devuelva un
número entero con el valor: -1 si el número es negativo, 1 si es positivo o 0 si
es cero.
*/

public class Ej1 {
    public static int signo(double n) {
        if (n >= 0) {
            return 1;
        } else {
            return -1;
        }
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
