import java.io.*;

/**
 * Reemplazar palabras específicas en un archivo. Desarrolla un programa que
 * lea un archivo de texto, reemplace todas las apariciones de una palabra
 * específica (por ejemplo, "hola") por otra palabra (por ejemplo, "adiós"), y
 * guarde el resultado en un nuevo archivo.
 **/
public class Ej23 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("archivoCopia.txt"))) {

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String lineaRemplazo = linea.replaceAll("[hola] | [Hola]", "adiós");
                bufferedWriter.write(lineaRemplazo);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
