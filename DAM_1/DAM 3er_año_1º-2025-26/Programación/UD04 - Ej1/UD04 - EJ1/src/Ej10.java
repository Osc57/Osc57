import java.util.Scanner;

/*
10. Crea una función que calcule el factorial de un número de manera iterativa.
!n = n*(n-1)*(n-2)* ... *2*1
*/
public class Ej10 {
    public static int factorial(int n) {

        if (n <= 0 || n == 1) {
            return 1;
        }

        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }

        return factorial;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");

        if (scanner.hasNextInt()) {
            int numero = scanner.nextInt();

            System.out.println(factorial(numero));
        }else {
            System.out.println("ERROR: Introduce un número entero");
        }

    }
}
