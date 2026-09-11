import java.util.Scanner;

/**
 * Modifica el programa anterior para que muestre al finalizar el número total de
 * caracteres que contenían las frases introducidas (sin contar el punto) y la
 * suma total letras ‘s’ introducidas.
 **/
public class Ej3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una frase indefinida: ");
        String frase = scanner.nextLine().toLowerCase().trim();

        String frases = frase.replaceAll(" ", "").replaceAll("\\.", "");

        int contador = 0;
        int letraS = 0;

        for (int i = 0; i < frases.length(); i++) {
            contador++;
            if (frases.charAt(i) == 's') {
                letraS++;
            }
        }
        System.out.println("Número total de caracteres: " + contador);
        System.out.println("Número total de letras 's' introducidas: " + letraS);
    }
}

