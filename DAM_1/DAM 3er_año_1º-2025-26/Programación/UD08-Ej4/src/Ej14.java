import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
14. Detectar palabras que empiezan con una letra mayúscula. Desarrolla una
expresión regular que detecte todas las palabras que comienzan con una letra
mayúscula en una cadena de texto. Considera las palabras separadas por espacios.
• “Hola Mundo” -> coincide con Hola y Mundo
• “hola mundo” -> no coincide con ninguna palabra
*/
public class Ej14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\b[A-Z][a-z]*\\b";

        System.out.print("Dime una frase con palabras que empiecen por mayúsculas: ");
        String frase = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(frase);

        System.out.print("Palabras que empiezan por mayúscula -> ");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }

    }
}
