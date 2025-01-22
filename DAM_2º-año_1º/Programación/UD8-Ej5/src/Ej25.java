import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contar las líneas que contienen una palabra específica. Desarrolla un
 * programa que lea un archivo de texto y muestre cuántas líneas contienen una
 * palabra específica que el usuario debe introducir.
 **/
public class Ej25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una palabra para ver si el archivo contiene esa palabra: ");
        String palabra = scanner.nextLine();

        Pattern patternPalabra = Pattern.compile("\\b" + palabra + "\\b");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"))) {

            String linea;
            int cuentaLineas = 0;
            while ((linea = bufferedReader.readLine()) != null) {
                Matcher matcherPalabra = patternPalabra.matcher(linea);
                if (matcherPalabra.find()){
                    cuentaLineas++;
                }
            }

            System.out.println("Hay " + cuentaLineas + " palabras en el archivo");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
