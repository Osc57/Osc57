/*
11. Crea una función que calcule el factorial de un número de manera recursiva.
*/

import java.util.Scanner;

public class Ej11 {

    public static int factorialRecursivo(int n){
        if (n <= 0 || n == 1) {
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");

        if (scanner.hasNextInt()){
            int n = scanner.nextInt();

            System.out.println(factorialRecursivo(n));
        }else {
            System.out.println("ERROR: Introduce un número entero");
        }
    }
}
