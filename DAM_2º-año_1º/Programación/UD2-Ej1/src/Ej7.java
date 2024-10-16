import java.util.Scanner;

/**
 *¿Qué método de la clase Math utilizarías para realizar el producto de dos enteros y
 * asegurarte de que el resultado no hace overflow? Haz un programa que lo pruebe.
 * **/
public class Ej7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int n1 = scanner.nextInt();

        System.out.print("Dime otro número: ");
        int n2 = scanner.nextInt();

        int producto = n1*n2;

        System.out.println(producto);
    }
}
