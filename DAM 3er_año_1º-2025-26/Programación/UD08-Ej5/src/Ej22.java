import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
22. Contar las palabras en un archivo. Desarrolla un programa que lea un archivo
de texto y muestre cuántas palabras contiene en total.
*/
public class Ej22 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea;

            int contador = 0;
            while ((linea = bufferedReader.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
                    String[] palabras = linea.split("[^a-zA-Z0-9áéíóúÁÉÍÓÚñÑ]+");

                    for (String p : palabras) {
                        if (!p.isEmpty()) {
                            contador++;
                        }
                    }
                }
            }
            System.out.println("Hay " + contador + " palabras");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
