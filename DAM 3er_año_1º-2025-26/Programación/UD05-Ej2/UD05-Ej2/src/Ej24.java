/*
24. Palíndromo. Un palíndromo es una palabra o expresión que es igual si se lee
de izquierda a derecha que de derecha a izquierda, por ejemplo, radar. Crea
un programa que pida al usuario introducir una palabra o expresión y valide si
es un palíndromo. La comprobación deberá ser independiente de mayúsculas
o minúsculas y de si las vocales llevan a no tildes.
*/

import java.util.Scanner;

public class Ej24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean esPalindromo = false;

        System.out.print("Dime tu frase y te dire si es palindroma: ");
        String frase = scanner.nextLine().trim();

        String fraseLimpia = frase.replace(" ", "").toLowerCase();

        esPalindromo = fraseLimpia.equalsIgnoreCase(new StringBuilder(frase).reverse().toString());

        if (esPalindromo) {
            System.out.println("La frase " + frase + " es palindroma");
        } else {
            System.out.println("La frase no es palindroma");
        }

    }
}
