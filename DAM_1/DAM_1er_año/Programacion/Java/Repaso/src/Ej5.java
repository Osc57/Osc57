import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número para cuenta regresiva: ");
        int numero = scanner.nextInt();
        for (int i = numero; i > 0; i--) {
            System.out.println(i);
        }
        System.out.println("Acabó la cuenta regresiva");
        scanner.close();
    }
}
