import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Encontrar y contar palabras de longitud específica. Desarrolla un programa
 * que lea un archivo de texto y cuente cuántas palabras tienen una longitud
 * específica (por ejemplo, de 5 letras). El usuario debe introducir la longitud
 * deseada.
 * **/
public class Ej26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la longitud de la palabra que desea buscar: ");
        int longitud = scanner.nextInt();

        Pattern patternLongitud = Pattern.compile("\\b\\w{"+longitud+"}\\b");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"))){

            String linea;
            int cuentaPalabras = 0;

            while ((linea = bufferedReader.readLine()) != null){
                Matcher matcherLongitud = patternLongitud.matcher(linea);
                if (matcherLongitud.find()){
                    cuentaPalabras++;
                    //System.out.println(matcherLongitud.group());
                }
            }
            System.out.println("Hay " + cuentaPalabras + " palabras de esa longitud en el archivo");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
