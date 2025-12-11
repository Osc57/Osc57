/*
21. Crea un programa que pida al usuario una frase. El programa deberá buscar
las letras ‘a’ independientemente de mayúsculas, minúsculas o de si lleva o no
tilde y mostrar cuantas hay y en qué posición están.
*/

import java.util.Scanner;

public class Ej21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una frase: ");
        String frase = scanner.nextLine().toLowerCase().trim();

        int contador = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == 'a') {
                contador++;
                System.out.println("La letra 'a' esta en la posición " + i + " de la palabra");
            }
        }

        if (contador > 0) {
            System.out.println("La letra 'a' aparece " + contador + " vez/ces");
        } else {
            System.out.println("No se encontraron letras 'a' en la frase");
        }
        scanner.close();
    }
}
