import java.util.Scanner;

/**
 * Crea un programa que genere un array de 10 números aleatorios mayores o
 * iguales a 0 y menores que 100. Después el programa mostrará los valores por
 * pantalla en una sola línea separados por espacios. A continuación, entrará en
 * bucle indefinido y pedirá al usuario que introduzca un número entero, el
 * programa indicará si dicho número está o no en el array. El programa parará
 * cuando el usuario introduzca un número negativo.
 * **/
public class Ej5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] aleatorios = new int [10];

        for (int i = 0; i < 10; i++) {
            aleatorios[i] = (int) (Math.random()*100);
        }
        /**
        for (int num : aleatorios){
            System.out.print(num + " ");
        }
        System.out.println();
         **/
        while (true){
            System.out.print("introduce un número entero (negativo para salir): ");
            int numero = scanner.nextInt();

            if (numero < 0){
                System.out.println("FIN");
                break;
            }

            for (int num : aleatorios) {
                if (num == numero) {
                    System.out.println("Encontrado");
                    break;
                }else {
                    System.out.println("No encontrado");
                    break;
                }
            }
        }

    }
}
