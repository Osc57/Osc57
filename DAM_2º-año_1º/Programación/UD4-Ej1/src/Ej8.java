import java.util.Scanner;

/**
 * Crear una función que calcule el mayor de dos números enteros que recibirá
 * como parámetros. El resultado será otro número entero. Desarrolla otra
 * implementación que reciba 2 números reales y devuelva un número real
 * (double).
 * **/
public class Ej8 {
    static int mayorDeDosNumeros(int n1, int n2){
        return Math.max(n1, n2);
    }

    static double mayorDosNumeros(double n1, double n2){
        return Math.max(n1, n2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int num1 = scanner.nextInt();

        System.out.print("Dime otro número: ");
        int num2 = scanner.nextInt();

        int mayor = mayorDeDosNumeros(num1,num2);

        double mayorDouble = mayorDosNumeros(num1,num2);

        System.out.println("El mayor es: " + mayor);
        System.out.println("El mayor es: " + mayorDouble);
    }
}
