import java.util.Arrays;
import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] frases;

        System.out.print("Dime una frase: ");
        String frase = scanner.nextLine();

        frases = frase.split(" ");//Separo frases por espacio

        Arrays.sort(frases);//Ordeno el array

        for (String s : frases) {//Selecciono todas las letras menos la ultima para lowerCase y selecciono la ultima letra para upperCase
            System.out.print(s.substring(s.indexOf(s), s.length() - 1).toLowerCase() + s.substring(s.length() - 1).toUpperCase() + " ");
        }

        /*
        Esto es práctica que he hecho
        String a = "hola";
        System.out.println();
        //a.substring(a.toLowerCase().charAt(0), a.toUpperCase().charAt(a.length() - 1));
        //System.out.println(a.toUpperCase().lastIndexOf(a.length()));
        //System.out.println(a.substring(a.toUpperCase().lastIndexOf(a, a.length()), a.length() - 1));
        //System.out.println(a.substring(a.toLowerCase().indexOf(a), a.length() - 1));
        */

    }
}
