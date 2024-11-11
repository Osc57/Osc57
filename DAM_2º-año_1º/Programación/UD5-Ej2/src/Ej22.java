import java.util.Scanner;

/**
 * Crea un programa que pida al usuario introducir una frase y después,
 * independientemente de cómo la haya escrito, elimine espacios sobrantes al
 * principio y al final y:
 * a. La muestre en mayúsculas. Ej. HOLA MUNDO
 * b. La muestre en minúsculas. Ej. hola mundo
 * c. La muestre con la primera letra de cada palabra en mayúsculas y el resto
 * en minúsculas. Ej. Hola Mundo
 * **/
public class Ej22 {
    static String[] devolverPalabras (String s){
        return s.split(" ");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una frase: ");
        String frase = scanner.nextLine().trim();

        String [] frases = devolverPalabras(frase);

        for (int i = 0; i < frases.length; i++) {
            String palabra = String.valueOf(frases[i].toUpperCase().charAt(0));
            System.out.print(palabra + " ");
        }
        System.out.println();
        System.out.println("Frase en mayúsculas: " + frase.toUpperCase());
        System.out.println("Frase en minúsculas: " + frase.toLowerCase());


    }
}
