import java.util.Scanner;

/**
 * Crea una función que calcule el factorial de un número de manera iterativa.
 * !n = n*(n-1)*(n-2)* ... *2*1
 * **/
public class Ej10 {
    static void calcularFactorial(int n1){
        int multiplicacion = 1;
        for (int i = 2; i <=n1 ; i++) {
            multiplicacion*=i;
        }
        System.out.println(n1 + "! " + multiplicacion);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int num1 = scanner.nextInt();

        calcularFactorial(num1);
    }
}
