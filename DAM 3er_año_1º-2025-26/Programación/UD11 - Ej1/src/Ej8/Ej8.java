package Ej8;

import java.util.Scanner;

/*
8. Crea un programa que pida al usuario introducir una frase y muestre las letras
ordenadas en orden alfabético junto con el número de veces que aparece dicha
letra en la frase.
*/

public class Ej8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una frase: ");
        String frase = scanner.nextLine().toLowerCase();

        int[] contador = new int[26];
        
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                contador[c - 'a']++;
            }
        }

        for (int i = 0; i < contador.length; i++) {
            if (contador[i] > 0) {
                System.out.println((char) (i + 'a') + ": " + contador[i]);
            }
        }
    }
}

