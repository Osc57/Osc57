import java.util.Scanner;

/**
 * Crear una función que tenga como parámetros de entrada 2 números enteros
 * y como parámetro de salida un doble con la media aritmética de ambos.
 * **/
public class Ej6 {
    static double mediaAritmetica(int n1, int n2){
        return (n1+n2)/2.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int num1 = scanner.nextInt();

        System.out.print("Dime otro número: ");
        int num2 = scanner.nextInt();

        double media = mediaAritmetica(num1,num2);

        System.out.println("La media es: " + media);

    }
}
