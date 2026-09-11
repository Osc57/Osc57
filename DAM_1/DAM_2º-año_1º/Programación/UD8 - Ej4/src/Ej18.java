import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Buscar palabras con al menos 5 letras. Desarrolla una expresión regular que
 * coincida con todas las palabras que tengan al menos 5 letras en una cadena de texto.
 * Una palabra está formada por letras mayúsculas y minúsculas.
 * • "En una casa grande vivía un niño" → coincide con grande
 * • "El sol brilla" → no coincide con ninguna palabra
 * **/
public class Ej18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una frase con al menos 5 letras: ");
        String frase = scanner.nextLine();

        String regexFrase = "\\b\\w{5,}\\b";

        Pattern patternFrase = Pattern.compile(regexFrase);
        Matcher matcherFrase = patternFrase.matcher(frase);

        while (matcherFrase.find()){
            System.out.println(matcherFrase.group());
        }

    }
}
