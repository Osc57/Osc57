import java.util.Scanner;
import java.util.SortedMap;

public class Ej1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vamos a dividir");
        System.out.print("Introduce un número: ");
        int num1 = scanner.nextInt();

        System.out.print("Introduce otro número: ");
        int num2 = scanner.nextInt();

        try {
            int division = num1/num2;
            System.out.println("La división de " + num1 + " y " + num2 + " es: " + division);

        }catch (ArithmeticException e){
            if ( num2 == 0){
                System.out.println("ERROR: No puedes dividir entre 0");
                e.printStackTrace();
            }

        }finally {
            scanner.close();
        }
    }
}
