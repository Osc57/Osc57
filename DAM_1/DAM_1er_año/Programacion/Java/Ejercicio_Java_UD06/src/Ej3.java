import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Ej3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número, y te devuelvo la raíz cuadrada: ");
        int numero = scanner.nextInt();

        double raiz = sqrt(numero);

        if (numero < 0){
            System.out.print("Error, no puedes meter un número negativo");
        }else
            System.out.print("La raíz de " + numero + " es: " + raiz);

        scanner.close();
    }
}
