/*
12. Crea una función que calcule el valor enésimo de la sucesión de Fibonacci
utilizando recursividad.
*/

public class Ej12 {
    public static int enesimoValorFibonacci(int n) {

        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return enesimoValorFibonacci(n - 1) + enesimoValorFibonacci(n - 2);

        }
    }

    public static void main(String[] args) {
        int numero = 11;

        System.out.println(enesimoValorFibonacci(numero));
    }
}
