import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
18. Buscar palabras con al menos 5 letras. Desarrolla una expresión regular que
coincida con todas las palabras que tengan al menos 5 letras en una cadena de texto.
Una palabra está formada por letras mayúsculas y minúsculas.
• "En una casa grande vivía un niño" → coincide con grande
• "El sol brilla" → no coincide con ninguna palabra
*/
public class Ej18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\b\\w{5,}\\b";

        System.out.print("Dime una frase: ");
        String frase = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(frase);

        System.out.print("Palabras de al menos 5 letras -> ");
        while (matcher.find()){
            System.out.print(matcher.group() + " ");
        }
    }
}
