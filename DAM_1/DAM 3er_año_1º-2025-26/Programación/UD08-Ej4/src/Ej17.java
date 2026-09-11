import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
17. Extraer números de una cadena. Crea una expresión regular que extraiga todos
los números (con o sin decimales) de una cadena de texto. Los números pueden
contener una coma o punto como separador decimal.
• "La temperatura es 23.5 grados y la humedad es 60%" → encuentra 23.5 y 60
• "La temperatura es veinte grados" → no encuentra nada
*/
public class Ej17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\d+[.,]?\\d*";

        System.out.print("Dime la temperatura y humedad que hacen: ");
        String numeros = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numeros);

        System.out.print("Números -> ");
        while (matcher.find()){
            System.out.print(matcher.group() + " ");
        }
    }
}
