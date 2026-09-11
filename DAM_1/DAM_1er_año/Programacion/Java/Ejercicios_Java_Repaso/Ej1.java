import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int num1 = scanner.nextInt();

        System.out.print("Dime otro número: ");
        int num2 = scanner.nextInt();

        System.out.print("Dime otro número: ");
        int num3 = scanner.nextInt();

        int mayor = Math.max(num1, num2);
        int mayor2 = Math.max(mayor, num3);

        if (num1 != num2 && num2 != num3 && num1 != num3) {
            System.out.println("El número mayor es: " + mayor2);
        } else {
            System.out.println("Hay un empate");
        }
        scanner.close();
    }
}
