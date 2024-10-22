import java.util.Scanner;

/**
 * Crea un programa que pida al usuario 2 números enteros y calcule la división
 * de ambos restado al primer número el segundo de manera sucesiva. Por
 * ejemplo: 7, 3 → 7 - 3 = 4, 4 – 3 = 1, como 1 es menor que 3 no puedo seguir.
 * La división igual a 2 que es el número de veces que se ha podido realizar la
 * resta.
 * **/
public class Ej11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resta = 0;

        System.out.print("Dime un número: ");
        int n1 = scanner.nextInt();

        System.out.print("Dime otro número: ");
        int n2 = scanner.nextInt();

       while (n1 >= n2){
           n1 -= n2;
           resta++;
       }
        System.out.println(resta);
    }
}
