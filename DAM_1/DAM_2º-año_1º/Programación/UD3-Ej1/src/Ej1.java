import java.util.Scanner;

/**
 * a. Codifica un programa que pida al usuario un número que represente
 * una cantidad expresada en pesetas. Si tenemos en cuenta que 1€ =
 * 166.386ptas, muestra por pantalla la conversión a euros de la cantidad
 * introducida en pesetas.
 * b. Realiza el ejercicio anterior teniendo en cuenta que la cantidad
 * introducida ha de ser mayor que cero, en otro caso el programa no hará
 * ninguna acción.
 * c. Modifica el programa anterior para que en caso de que el número no
 * sea mayor que cero muestre el siguiente mensaje en pantalla “El valor
 * introducido debe ser mayor que cero.”
 * **/
public class Ej1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una cantidad de pesetas: ");
        long pesetas = scanner.nextLong();

        double euros = pesetas/166.368;

        if (pesetas > 0){
            System.out.printf("La cantidad de euros es: %.2f €%n",euros);
        }else {
            System.out.println("El valor introducido debe ser mayor a cero");
        }

        scanner.close();

    }
}
