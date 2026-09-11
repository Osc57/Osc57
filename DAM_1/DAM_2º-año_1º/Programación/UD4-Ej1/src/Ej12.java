import java.util.Scanner;

/**
 * Crea una función que calcule el valor enésimo de la sucesión de Fibonacci
 * utilizando recursividad.
 * Sucesión de Fibonacci: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
 * Definición recursiva: f(n) = f(n-1) + f(n-2) con f(0) = 0 y f(1) = 1.
 * **/
public class Ej12 {
    static int fibonacci(int m){
        if (m <= 0){
            return 0;
        } else if (m==1) {
            return 1;
        }else {
            return fibonacci(m - 1) + fibonacci(m - 2);
        }
    }

    public static void main(String[] args) {
        int numero = 11;

        int fibo = fibonacci(numero);

        System.out.println(fibo);
    }

}
