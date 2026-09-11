import java.util.Scanner;

/**
 * Desarrolla un programa que pida al usuario introducir una frase y después la
 * mostrará por consola tras formatearla de la siguiente manera:
 * a. Se eliminarán los espacios sobrantes al inicio y al final de la frase.
 * b. Mostrará la frase con la primera letra de cada palabra en
 * mayúsculas y el resto en minúsculas.
 **/
public class Ej9 {
    static String[] devolverPalabras(String s) {
        return s.split(" ");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una frase: ");
        String frase = scanner.nextLine().trim();

        String[] frases = devolverPalabras(frase);

        for (String f : frases) {
            System.out.print(f.substring(0, 1).toUpperCase() + f.substring(1).toLowerCase() + " ");
        }

    }
}
