import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Detectar palabra con caracteres especiales. Escribe una expresión regular para
 * encontrar todas las palabras que contengan al menos un carácter especial (@, #, %, etc.)
 * en una cadena de texto.
 * • "Hola #mundo, ¿cómo estás?" → coincide con #mundo
 * • "Hola mundo" → no coincide con ninguna palabra
 * **/
public class Ej20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escribe una palabra con caracteres especiales: ");
        String palabra = scanner.nextLine();

        String regexPalabra = "\\w*\\W+\\w*";

        Pattern patternPalabra = Pattern.compile(regexPalabra);
        Matcher matcherPalabra = patternPalabra.matcher(palabra);

        while (matcherPalabra.find()){
            System.out.println(matcherPalabra.group());
        }


    }
}
