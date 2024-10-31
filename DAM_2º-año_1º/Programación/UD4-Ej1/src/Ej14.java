import java.util.Scanner;

/**
 * Realiza una función recursiva que dado un número entero calcule la suma de
 * todas sus cifras.
 * **/
public class Ej14 {
    static int sumaCifras(int n){
        if (n == 0){
            return 0;
        }
        return (n%10) + sumaCifras(n/10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int n1 = scanner.nextInt();

        int suma = sumaCifras(n1);

        System.out.println("La suma es: " + suma);
    }
}
