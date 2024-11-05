import java.util.Arrays;
import java.util.Scanner;

/**
 * Crea un programa que pida al usuario introducir una lista de nombres;
 * primero pedirá cuantos nombres va a introducir, después pedirá introducir
 * esos nombres. Los datos se guardarán en un array. Después el programa
 * mostrará la lista ordenada por orden alfabético.
 * **/
public class Ej13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Cuantos nombres quieres meter al Array: ");
        int numero = scanner.nextInt();

        scanner.reset();
        String [] nombres = new String[numero];

        for(int i=0; i<numero; i++){
            //System.out.println("entra");
            //nombres[i] = "entra";
            System.out.print("Dime un nombre: ");
            String nombre = scanner.next();
            nombres[i] = nombre;
        }

       Arrays.sort(nombres);
        System.out.println("Array ordenado");
        for (String nom : nombres){
            System.out.print(nom + " ");
        }

    }
}
