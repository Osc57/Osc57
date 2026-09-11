import java.util.Random;
import java.util.Scanner;

public class Aleatorio {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int aleatorio = random.nextInt(1,100);

        int contador = 0;
        while (true){
            System.out.print("Adivina el número entre 1 y 100: ");
            int numero = scanner.nextInt();

            if (aleatorio > numero){
                System.out.println("El número es mayor");
                contador = contador+1;
            }else {
                System.out.println("El número es menor");
                contador = contador+1;
            }
            if (aleatorio==numero){
                System.out.println("ENOHORABUENA!!! Has adivinado el número en " + contador + " intentos");
                break;
            }
        }
    }
}

