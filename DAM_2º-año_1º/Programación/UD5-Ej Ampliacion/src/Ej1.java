import java.util.Arrays;
import java.util.Scanner;

/**
 * Desarrolla un programa que pida al usuario introducir una lista de números
 * separados por comas, el programa deberá ignorar, si los hubiera, los espacios
 * entre números y comas. También deberá ignorar datos no numéricos, si los
 * hubiera. El programa deberá mostrar los números ordenados de mayor a
 * menor.
 **/
public class Ej1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una lista de números separados por comas: ");
        String numero = scanner.nextLine().trim();

        String[] numeros = numero.replaceAll(" ", "").split(",");

        int contador = 0;
        for (String n : numeros) {
            contador++;
        }

        int[] enteros = new int[contador];

        for (int i = 0; i < numeros.length; i++) {
            try {
                int num = Integer.parseInt(numeros[i]);
                enteros[i] = num;
            } catch (Exception e) {

            }

        }
        Arrays.sort(enteros);

        for (int n : enteros) {
            System.out.print(n + " ");
        }
    }
}
