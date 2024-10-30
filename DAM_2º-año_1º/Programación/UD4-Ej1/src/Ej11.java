import java.util.Scanner;

/**
 * Crea una función que calcule el factorial de un número de manera recursiva.
 * **/
public class Ej11 {
    static int calcularFactorial(int n1){
        if (n1 <= 1) {
            return n1;
        }
        return n1 * calcularFactorial(n1-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int num1 = scanner.nextInt();

        int factorial = calcularFactorial(num1);
        System.out.println("El factorial de " + num1 + " es: " + factorial);
    }
}
