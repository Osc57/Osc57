import java.util.Scanner;

/**
 * Realiza un programa que pida al usuario introducir dos números y muestre el resultado
 * de elevar el primero al segundo.
 * **/
public class Ej9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int n1 = scanner.nextInt();

        System.out.print("A cuanto quieres elevar el número: ");
        int n2 = scanner.nextInt();

        int resultado = (int) Math.pow(n1,n2);

        System.out.println(resultado);
    }
}
