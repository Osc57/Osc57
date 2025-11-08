import java.util.Random;
import java.util.Scanner;

public class Ej {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        boolean jugarOtraVez;

        do {
            int revolver = random.nextInt(6) + 1;
            int contador = 1;
            int balas = 6;

            System.out.println("RULETA RUSA");
            System.out.println("ELIJE A UN AMIGO");
            System.out.println("======================================");

            do {
                System.out.print("Dispara el gatillo (pulsa Enter) ");
                scanner.nextLine();

                if (contador == revolver) {
                    System.out.println("💥 GAME OVER");
                    System.out.println("Has muerto en la bala " + revolver);
                    break;
                } else if (balas - contador == 1) {
                    System.out.println("🎉 ¡Has sobrevivido!");
                    System.out.println("Queda solo una bala en el tambor, eres el ganador.");
                    break;
                } else {
                    System.out.println("Estás a salvo");
                    System.out.println("Balas restantes: " + (balas - contador));
                    System.out.println("======================================");
                }

                contador++;
            } while (contador <= balas);

            System.out.print("¿Quieres jugar otra vez? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            jugarOtraVez = respuesta.equals("s");

        } while (jugarOtraVez);

        System.out.println("Gracias por jugar. ¡Hasta la próxima!");
        scanner.close();
    }
}
