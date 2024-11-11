import java.util.Arrays;
import java.util.Scanner;

/**
 * Desarrolla un programa que pida al usuario varios números separados por
 * comas y muestre su suma.
 * **/
public class Ej19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Dame una serie de números separados por comas: ");
        String numero = scanner.next();
        String [] numeros = numero.split(",");

        int suma = 0;

        for (String n : numeros){
            n = n.trim();
            try {
                suma = suma + Integer.parseInt(n);
            }catch (Exception e){
                System.out.println("ERROR: Se ha detectado una coma");
            }
        }
        System.out.println("La suma de los números es: " + suma);

        scanner.close();


    }

}
