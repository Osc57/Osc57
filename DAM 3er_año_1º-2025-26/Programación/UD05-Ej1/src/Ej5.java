/*
5. Crea un programa que genere un array de 10 números aleatorios mayores o
iguales a 0 y menores que 100. Después el programa mostrará los valores por
pantalla en una sola línea separados por espacios. A continuación, entrará en
bucle indefinido y pedirá al usuario que introduzca un número entero, el
programa indicará si dicho número está o no en el array. El programa parará
cuando el usuario introduzca un número negativo.
*/

import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] aleatorios = new int[10];
        boolean negativo;

        for (int i = 0; i < 10; i++) {
            aleatorios[i] = (int) (Math.random() * 100);
        }

        for (int n : aleatorios) {
            System.out.print(n + " ");
        }
        System.out.println();

        do {
            System.out.print("Introduce un número entero (negativo para salir): ");
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                if (n < 0) {
                    System.out.println("FIN PROGRAMA");
                    negativo = true;
                } else {
                    boolean encontrado = false;
                    for (int num : aleatorios) {
                        if (num == n) {
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) {
                        System.out.println("NÚMERO ENCONTRADO");
                    } else {
                        System.out.println("NÚMERO NO ENCONTRADO");
                    }
                    negativo = false;
                }
            } else {
                System.out.println("NÚMERO ENTERO O ENTERO NEGATIVO");
                scanner.next();
                negativo = false;
            }
        } while (!negativo);
    }
}
