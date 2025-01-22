import java.io.*;

/**
 * Invertir el contenido de cada línea. Desarrolla un programa que lea un archivo
 * de texto y cree un nuevo archivo donde cada línea del texto original esté
 * invertida (de derecha a izquierda).
 **/
public class Ej24 {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("archivoInvertido.txt"))) {

            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
               String lineaInvertida = new StringBuilder(linea).reverse().toString();
               bufferedWriter.write(lineaInvertida);
               bufferedWriter.newLine();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
