import java.util.Scanner;

/**
 * Palíndromo. Un palíndromo es una palabra o expresión que es igual si se lee
 * de izquierda a derecha que de derecha a izquierda, por ejemplo, radar. Crea
 * un programa que pida al usuario introducir una palabra o expresión y valide si
 * es un palíndromo. La comprobación deberá ser independiente de mayúsculas
 * o minúsculas y de si las vocales llevan a no tildes.
 **/
public class Ej24 {
    static String cadenaInversa(String cadena) {
        String inversa = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            inversa = inversa + cadena.charAt(i);
        }
        return inversa;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una palabra para comprobar si es un palindromo: ");
        String palabra = scanner.nextLine().toLowerCase();

        if (palabra.equals(cadenaInversa(palabra))) {
            System.out.println("La palabra " + palabra + " es un palindromo");
        } else {
            System.out.println("La palabra " + palabra + " no es un palindromo");
        }
    }
}
