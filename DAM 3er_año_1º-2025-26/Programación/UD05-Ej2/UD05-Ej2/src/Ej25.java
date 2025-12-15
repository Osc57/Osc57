/*
25. Palíndromo. Resuelve el problema anterior utilizando recursividad de
funciones.
*/

import java.util.Scanner;

public class Ej25 {
    public static String limpiarPalabra(String p) {
        String tildes = "àáâãäåæçèéêëìíîïðñòóôõöøùúûüýÿ";
        String letras = "aaaaaaaceeeeiiiionoooooouuuuyy";
        String palabraLimpia = p.replace(" ", "");
        for (int i = 0; i < tildes.length(); i++) {
            palabraLimpia = palabraLimpia.replace(tildes.charAt(i), letras.charAt(i));
        }
        return palabraLimpia;
    }

    public static String cadenaInversa(String cadena) {
        StringBuilder inversa = new StringBuilder();
        for (int i = cadena.length() - 1; i >= 0; i--) {
            inversa.append(cadena.charAt(i));
        }
        return limpiarPalabra(inversa.toString());
    }

    public static void comporbarPalabra(String s) {
        if (limpiarPalabra(s).equals((cadenaInversa(s)))) {
            System.out.println("La palabra " + s + " es un palindromo");
        } else {
            System.out.println("La palabra " + s + " no es un palindromo");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una palabra para comprobar si es un palindromo: ");
        String palabra = scanner.nextLine().toLowerCase();

        comporbarPalabra(palabra);
    }
}
