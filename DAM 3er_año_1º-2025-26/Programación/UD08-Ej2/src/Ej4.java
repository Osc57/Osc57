import java.io.*;

/*
4. Desarrolla un programa que lea un archivo de texto y muestre su
contenido.
*/
public class Ej4 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"));) {
            String linea;

            System.out.println("CONTENIDO DEL ARCHIVO");
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
