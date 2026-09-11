/*
6. Desarrolla un programa que lea un archivo de texto y muestre el
número de veces que aparece la letra ‘a’.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej6 {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea;
            int contador = 0;
            String variantesA = "aáàâäãAÁÀÂÄÃ";

            while ((linea = bufferedReader.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    if (variantesA.indexOf(linea.charAt(i)) != -1) {
                        contador++;
                    }
                }
            }
            System.out.println("La letra 'a' aparece " + contador + " veces");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
