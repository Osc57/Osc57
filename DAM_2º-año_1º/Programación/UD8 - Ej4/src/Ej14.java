import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Detectar palabras que empiezan con una letra mayúscula. Desarrolla una
 * expresión regular que detecte todas las palabras que comienzan con una letra
 * mayúscula en una cadena de texto. Considera las palabras separadas por espacios.
 * • “Hola Mundo” -> coincide con Hola y Mundo
 * • “hola mundo” -> no coincide con ninguna palabra
 * **/
public class Ej14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce palabras para saber si la primera letra de cada una es mayúscula: ");
        String palabras = scanner.nextLine();

        String regexPalabra = "\\b[A-Z][a-z]*\\b";

        Pattern patternPalabra = Pattern.compile(regexPalabra);
        Matcher matcherPalabra = patternPalabra.matcher(palabras);

        while (matcherPalabra.find()){
            System.out.println(matcherPalabra.group());
        }
    }
}
