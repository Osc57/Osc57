import java.util.Scanner;

public class Depurar {
    public static void main(String[] args) {
        Scanner NumScanner = new Scanner(System.in);

        int sum = 0, inputNum;
        int contador = 0;
        double mean;

        System.out.print("Ingresa el número total de términos que quieres que calcule la media: ");
        int counter = NumScanner.nextInt();

        for (int x = 0; x < counter; x++) {
            System.out.print("Por favor ingresa el " + (x +1) + " número: ");
            inputNum = NumScanner.nextInt();

            sum = sum + inputNum;
            contador++;
        }

        mean = (double) sum / contador;
        System.out.println("La media de " + sum + " los números que ingresaste es " + mean);
    }
}
