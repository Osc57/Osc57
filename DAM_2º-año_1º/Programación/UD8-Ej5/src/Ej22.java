import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Contar las palabras en un archivo. Desarrolla un programa que lea un archivo
 * de texto y muestre cuántas palabras contiene en total.
 * **/
public class Ej22 {


    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"))){
            String linea;

            int contador = 0;
            while ((linea = bufferedReader.readLine()) != null){
                String [] palabras = linea.split("\\s+");
                contador = contador + palabras.length;

            }
            System.out.println("Hay " + contador + " palabras");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
