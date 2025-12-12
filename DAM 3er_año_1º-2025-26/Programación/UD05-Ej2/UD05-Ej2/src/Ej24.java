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
        String tildes = "àáâãäåæçèéêëìíîïðñòóôõöøùúûüýÿ";
        String letras = "aaaaaaaceeeeiiiionoooooouuuuyy";
        StringBuilder palabraInversa = new StringBuilder();

        System.out.print("Dime una palabra para comprobar si es un palindromo: ");
        String palabra = scanner.nextLine().toLowerCase();

        String palabraLimpia = palabra.replace(" ", "");
        for (int i = 0; i < tildes.length(); i++) {
            palabraLimpia = palabraLimpia.replace(tildes.charAt(i), letras.charAt(i));
        }
        for (int i = palabraLimpia.length() - 1; i >= 0; i--) {
            palabraInversa.append(palabraLimpia.charAt(i));
        }

        if (palabraLimpia.contentEquals(palabraInversa)) {
            System.out.println("La palabra " + palabra + " es un palindromo");
        } else {
            System.out.println("La palabra " + palabra + " no es un palindromo");
        }

    }
}
