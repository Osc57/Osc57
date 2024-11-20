import java.util.Arrays;
import java.util.Scanner;

/**
 * Desarrolla un programa que pida al usuario introducir 10 números enteros
 * entre 1 y 9999. Si el usuario introduce números fuera de ese rango, el
 * programa los ignorará. El programa deberá mostrar los diez números
 * ordenados de menor a mayor formateados con 4 dígitos, es decir con ceros a
 * la izquierda si fuera necesario (por ejemplo, 5  0005, 978  0978).
 **/
public class Ej5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[10];
        int numero;
        int contador = 0;

        do {
            System.out.print("Dime un número: ");
            numero = scanner.nextInt();
            if (numero >= 1 && numero <= 9999) {
                numeros[contador] = numero;
                contador++;
            }
        } while (contador < 10);

        Arrays.sort(numeros);
        for (int n : numeros) {
            System.out.print(n + " ");
        }
    }
}
