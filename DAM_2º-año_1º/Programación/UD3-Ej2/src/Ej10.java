import java.util.Scanner;

/**
 * Crea un programa que pida al usuario 2 números enteros y calcule la
 * multiplicación de ambos aplicando sumas sucesivas del primer número tantas
 * veces como valga el segundo. Por ejemplo: 2, 3 → 2 * 3 = 2 + 2 + 2 (3 veces).
 * **/
public class Ej10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int suma = 0;

        System.out.print("Dime un número: ");
        int n1 = scanner.nextInt();

        System.out.print("Dime otro número: ");
        int n2 = scanner.nextInt();

        for (int i = 0; i < n1; i++) {
            suma = suma+n2;
        }
        System.out.println(suma);
    }
}
