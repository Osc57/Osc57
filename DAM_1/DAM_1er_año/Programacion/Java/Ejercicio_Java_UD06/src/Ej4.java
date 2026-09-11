import java.util.Random;
import java.util.Scanner;


public class Ej4 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int aleatorio = random.nextInt(101);
        System.out.println("El número aleatorio generado es: " + aleatorio);


        System.out.print("Dime un número entero positivo: ");
        int numero_entero = scanner.nextInt();

        if (numero_entero < 0){
            System.out.print("Error, introduce un número positivo");
        }else {
            int contador = 3;
                while (contador > 0) {
                    int num_aleatorio = random.nextInt(numero_entero);
                    System.out.print(num_aleatorio + ", ");
                    contador -= 1;
                }

        }
    }



}
