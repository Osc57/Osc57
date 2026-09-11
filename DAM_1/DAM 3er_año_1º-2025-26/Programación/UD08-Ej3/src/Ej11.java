/*
11. Crea un programa que utilice expresiones regulares para eliminar espacios
sobrantes de una cadena de caracteres.
*/

import java.util.Scanner;

public class Ej11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una frase: ");
        String frase = scanner.nextLine();

        String fraseUnida = frase.trim().replaceAll("\\s+", " ");

        System.out.println(fraseUnida);

    }
}
