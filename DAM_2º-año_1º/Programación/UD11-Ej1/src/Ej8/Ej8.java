package Ej8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Crea un programa que pida al usuario introducir una frase y muestre las letras
 * ordenadas en orden alfabético junto con el número de veces que aparece dicha
 * letra en la frase.
 **/

public class Ej8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listaCaracteres = new ArrayList<>();

        System.out.print("Dime una frase: ");
        String frase = scanner.nextLine().toLowerCase();

        char[] letras = frase.toCharArray();
        int contador = 0;
        for (char l = 'a';l<='z';l++){
            listaCaracteres.add(String.valueOf(l));
        }

        for (String c : listaCaracteres){
            for (int i = 0; i < letras.length -1; i++) {
                if (c.equals(String.valueOf(letras[i]))){
                    contador++;
                }
            }
            System.out.println(c + " aparece " + contador + " veces");
            contador=0;
        }
    }
}
