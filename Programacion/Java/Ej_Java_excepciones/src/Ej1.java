import java.util.Scanner;
import java.util.SortedMap;

public class Ej1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vamos a dividir");
        System.out.print("Introduce un número: ");
        float num1 = scanner.nextInt();

        System.out.print("Introduce otro número: ");
        float num2 = scanner.nextInt();

        try {
            float division = num1/num2;
            System.out.println("La división de " + num1 + " y " + num2 + " es: " + division);

        }catch (ArithmeticException e){
            if ( num2 == 0){
                System.out.println("No puedes dividir entre 0");
            }

        }finally {
            scanner.close();
        }
    }
}
