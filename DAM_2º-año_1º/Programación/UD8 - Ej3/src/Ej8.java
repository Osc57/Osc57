import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Desarrolla un programa que lea un archivo de texto y muestre el número
 * palabras que contiene.
 **/
public class Ej8 {
    public static void main(String[] args) {
        int contador = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
               String[] lineas = linea.split("\\s|\n");

                for (String l : lineas){
                    contador++;
                }

            }
            System.out.println("El archivo de texto contiene " + contador + " palabras");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
