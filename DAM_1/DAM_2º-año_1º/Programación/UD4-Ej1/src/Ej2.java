import java.util.Scanner;

/**
 * Crear una función que calcule el menor de dos números enteros que recibirá
 * como parámetros. El resultado será otro número entero.
 * **/
public class Ej2 {

    static void calcularMenor(int n1,int n2){
        if (n1 < n2){
            System.out.println("El numero menor es: " + n1);
        }else {
            System.out.println("El número menor es: " + n2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int num1 = scanner.nextInt();

        System.out.print("Dime otro número: ");
        int num2 = scanner.nextInt();

        calcularMenor(num1,num2);
    }
}
