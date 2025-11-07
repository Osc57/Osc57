import java.util.Random;
import java.util.Scanner;

public class Ej {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int revolver = random.nextInt(1, 10);
        int contador = 1;
        int balas = 10;
        
        System.out.println("RULETA RUSA");
        System.out.println("ELIJE A UN AMIGO");
        do {
            System.out.print("Dispara el gatillo");
            scanner.nextLine();
            System.out.println("Estás a salvo");
            System.out.println("Balas restantes " + (balas -= 1));
            System.out.println();
            contador++;
        } while (contador != revolver);
        System.out.println("GAME OVER");
        System.out.println("Has muerto por la bala " + revolver);

    }
}
