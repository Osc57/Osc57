import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reemplazar palabras específicas en un archivo. Desarrolla un programa que
 * lea un archivo de texto, reemplace todas las apariciones de una palabra
 * específica (por ejemplo, "hola") por otra palabra (por ejemplo, "adiós"), y
 * guarde el resultado en un nuevo archivo.
 **/
public class Ej23 {
    public static void main(String[] args) {
        String palabraRegex = "\\b(Hh)ola\\b";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("archivoNuevo.txt"))) {

            String linea;

            Pattern patternRegex = Pattern.compile(palabraRegex);
            while ((linea = bufferedReader.readLine()) != null) {
                Matcher matcherRegex = patternRegex.matcher(linea);
                String lineaRemplazo = matcherRegex.replaceAll("adiós");
                bufferedWriter.write(lineaRemplazo);
                bufferedWriter.newLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
