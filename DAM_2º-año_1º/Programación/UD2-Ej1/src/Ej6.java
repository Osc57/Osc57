import java.util.Scanner;

/**
 * Realiza un programa que pida al usuario introducir dos números enteros y que
 * muestre:
 * 1. el mayor
 * 2. el menor
 * 3. si el mayor es múltiplo del menor
 * **/
public class Ej6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int n1 = scanner.nextInt();

        System.out.print("Dime otro número: ");
        int n2 = scanner.nextInt();

        int mayor = Math.max(n1,n2);
        boolean comprobar = (n1%n2==0);

        System.out.println("El número mayor de " + n1 + " y " + n2 + " es: " + mayor);
        System.out.println(comprobar);
    }
}
