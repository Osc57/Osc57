import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
23. Reemplazar palabras específicas en un archivo. Desarrolla un programa que
lea un archivo de texto, reemplace todas las apariciones de una palabra
específica (por ejemplo, "hola") por otra palabra (por ejemplo, "adiós"), y
guarde el resultado en un nuevo archivo.
*/
public class Ej23 {
    public static void main(String[] args) {
        String regex = "\\sy\\s|\\sY\\s";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("archivoReemplazarPalabras.txt"))) {

            String linea;
            Pattern pattern = Pattern.compile(regex);
            while ((linea = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(linea);
                String reemplazo = matcher.replaceAll(" o ");
                bufferedWriter.write(reemplazo);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
