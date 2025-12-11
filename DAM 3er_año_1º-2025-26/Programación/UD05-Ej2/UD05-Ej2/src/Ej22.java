/*
22. Crea un programa que pida al usuario introducir una frase y después,
independientemente de cómo la haya escrito, elimine espacios sobrantes al
principio y al final y:
a. La muestre en mayúsculas. Ej. HOLA MUNDO
b. La muestre en minúsculas. Ej. hola mundo
c. La muestre con la primera letra de cada palabra en mayúsculas y el resto
en minúsculas. Ej. Hola Mundo
*/

import java.util.Scanner;

public class Ej22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] frases;


        System.out.print("Dime una frase: ");
        String frase = scanner.nextLine().toLowerCase().trim();

        System.out.println("Frase en Mayúsculas: " + frase.toUpperCase());
        System.out.println("Frase en Minúsculas: " + frase.toLowerCase());

        frases = frase.split(" ");

        System.out.print("Primera Letra Mayúscula: ");
        for (String f : frases) {
            System.out.print(f.substring(0, 1).toUpperCase() + f.substring(1).toLowerCase() + " ");
        }

    }
}
