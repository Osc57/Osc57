import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
20. Detectar palabra con caracteres especiales. Escribe una expresión regular para
encontrar todas las palabras que contengan al menos un carácter especial (@, #, %, etc.)
en una cadena de texto.
• "Hola #mundo, ¿cómo estás?" → coincide con #mundo
• "Hola mundo" → no coincide con ninguna palabra
*/
public class Ej20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escribe una palabra con caracteres especiales: ");
        String palabra = scanner.nextLine();

        String regex = "\\S*[^a-zA-Z0-9\\s]\\S*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(palabra);

        System.out.print("Coinciden -> ");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }


    }
}
