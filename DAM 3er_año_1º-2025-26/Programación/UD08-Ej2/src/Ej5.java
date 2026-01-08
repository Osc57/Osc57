/*
5. Desarrolla un programa que lea un archivo de texto y guarde un
nuevo archivo con el mismo texto, pero con todas las palabras en mayúsculas.
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Ej5 {
    public static void main(String[] args) {
        Path ruta = Paths.get("archivo.txt");
        Path rutaCopia = Paths.get("archivoCopia.txt");

        try {
            Files.copy(ruta, rutaCopia, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("archivoCopia.txt"))) {
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                bufferedWriter.write(linea.toUpperCase());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
