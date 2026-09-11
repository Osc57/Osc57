import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el primer número: ");
        int numero = scanner.nextInt();
        System.out.print("Ingresa el primer número: ");
        int numero2 = scanner.nextInt();
        System.out.print("Ingresa el primer número: ");
        int numero3 = scanner.nextInt();

        if (numero <= numero2 && numero <= numero3) {
            System.out.println("El mínimo es: " + numero);
        } else if (numero2 <= numero && numero2 <= numero3) {
            System.out.println("El mínimo es: " + numero2);
        } else {
            System.out.println("El mínimo es: " + numero3);
        }



    }
}
