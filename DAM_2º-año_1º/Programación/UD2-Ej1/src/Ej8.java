import java.util.Scanner;

/**
 * Realiza un programa que pida al usuario introducir dos números, calcule el cociente
 * entre ambos y muestre el resultado con una precisión de 3 decimales.
 * **/
public class Ej8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int n1 = scanner.nextInt();

        System.out.print("Dime otro número: ");
        int n2 = scanner.nextInt();


        float resultado = n1/n2;

        System.out.println(resultado);
    }
}
