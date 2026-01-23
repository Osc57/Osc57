import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
26. Encontrar y contar palabras de longitud específica. Desarrolla un programa
que lea un archivo de texto y cuente cuántas palabras tienen una longitud
específica (por ejemplo, de 5 letras). El usuario debe introducir la longitud
deseada.
*/
public class Ej26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int longitud = 0;
        System.out.print("Introduce la longitud de la palabra a buscar: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, introduzca un número válido.");
            System.out.print("Introduce la longitud de la palabra a buscar: ");
            scanner.next();
        }
        longitud = scanner.nextInt();

        int contador = 0;
        String regex = "(?i)\\b[a-záéíóúñ]{" + longitud + "}\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(linea);

                while (matcher.find()) {
                    contador++;
                    //System.out.println("Palabra " + contador + ": " + matcher.group());
                }
            }
            System.out.println("Se encontraron " + contador + " palabras de " + longitud + " letras.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
