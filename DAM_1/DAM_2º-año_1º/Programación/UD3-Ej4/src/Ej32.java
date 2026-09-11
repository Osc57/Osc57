import java.util.Scanner;

/**
 * Realiza un programa que pida introducir un número entero por la consola.
 * Después deberá mostrar los divisores enteros del número.
 * Ejemplo: 24 → 2, 3, 4, 6, 8, 12
 * **/
public class Ej32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int n1 = scanner.nextInt();

        for (int i = 2; i < n1; i++) {
            if (n1 % i == 0){
                System.out.print(i + ",");
            }
        }
    }
}
