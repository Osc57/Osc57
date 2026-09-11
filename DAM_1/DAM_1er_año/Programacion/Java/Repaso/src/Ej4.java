import java.util.Random;
import java.util.Scanner;


public class Ej4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroAleatorio = random.nextInt(1, 100);
        int intentos = 0;

        System.out.println(numeroAleatorio);
        while (true){
            System.out.print("Adivina el número: ");
            intentos++;
            int numero = scanner.nextInt();
            if (numeroAleatorio==numero){
                System.out.println("HAS ACERTADO EL NÚMERO EN " + intentos + " INTENTOS");
                break;
            } else if (numero < numeroAleatorio){
                System.out.println("El número es mayor");

            }else if (numero > numeroAleatorio) {
                System.out.println("El número es menor");
            }
        }
        scanner.close();
    }
}
