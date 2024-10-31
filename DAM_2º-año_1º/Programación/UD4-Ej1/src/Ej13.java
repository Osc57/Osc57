import java.util.Scanner;

/**
 * Desarrolla una función que escriba la sucesión de Fibonacci hasta número de
 * secuencia dado.
 * **/
public class Ej13 {
    static void fibonacci(int f){
        int fibo = 0;
        int siguenteNumero = 1;
        for (int i = 0; i < f; i++) {
            System.out.print(fibo + " ");
            int suma = fibo + siguenteNumero;
            fibo = siguenteNumero;
            siguenteNumero = suma;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int n1 = scanner.nextInt();

        fibonacci(n1);
    }
}
