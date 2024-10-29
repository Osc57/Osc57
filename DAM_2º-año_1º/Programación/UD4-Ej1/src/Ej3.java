import java.util.Scanner;

/**
 * Crea una función que calcule un número elevado a otro, usando
 * multiplicaciones sucesivas.
 * **/
public class Ej3 {
    static void numeroElevado(int n,int pot){
        int resultado = 1;
        for (int i = 0; i < pot; i++) {
            resultado = resultado*n;
        }
        System.out.println("La potencia es: " + resultado);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int num1 = scanner.nextInt();

        System.out.print("Dime la potencia a la que quieres elevar el número: ");
        int potencia = scanner.nextInt();

        numeroElevado(num1,potencia);

    }

}
