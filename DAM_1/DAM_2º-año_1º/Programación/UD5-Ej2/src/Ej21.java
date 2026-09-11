import java.util.Scanner;

/**
 * Crea un programa que pida al usuario una frase. El programa deberá buscar
 * las letras ‘a’ independientemente de mayúsculas, minúsculas o de si lleva o no
 * tilde y mostrar cuantas hay y en qué posición están.
 * **/
public class Ej21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una frase: ");
        String frase = scanner.next().toLowerCase();

        int contador = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == 'a' || frase.charAt(i) == 'á'|| frase.charAt(i) == 'à' || frase.charAt(i) == 'ä'
            || frase.charAt(i) == 'â' || frase.charAt(i) == 'ã'){
                contador++;
                System.out.println("La letra 'a' se encuentra en la posición " + i);
            }
        }
        System.out.println("La frase tiene un total de " + contador + " letras a");


    }
}
