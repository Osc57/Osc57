import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Desarrolla un programa que lea un archivo un archivo de texto y muestre el
 * número de veces que aparece cada letra del abecedario (independientemente
 * de mayúsculas y minúsculas).
 **/
public class Ej7 {
    public static void main(String[] args) {

        int[] contadorLetras = new int[26];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"))) {

            String linea;

            while ((linea = bufferedReader.readLine()) != null){
                linea = linea.toLowerCase();

                for (int i = 0; i < linea.length(); i++) {
                    char letra = linea.charAt(i);

                    if (letra >= 97 && letra <=122){
                        contadorLetras[letra - 97]++;
                    }
                }
            }

            for (char l = 'a'; l <= 'z'; l++) {
                int indice = l - 97;
                if (contadorLetras[indice] > 0) {
                    System.out.println(l + ": " + contadorLetras[indice]);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
