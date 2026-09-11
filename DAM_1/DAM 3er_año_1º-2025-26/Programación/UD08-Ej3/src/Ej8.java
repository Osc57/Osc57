/*
8. Desarrolla un programa que lea un archivo de texto y muestre el número
palabras que contiene.
*/

import java.io.*;

public class Ej8 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"))) {

            String linea;
            int contador = 0;
            while ((linea = bufferedReader.readLine()) != null) {

                String[] lineas = linea.split("\\s|\n");
                for (String l : lineas) {
                    contador++;
                }
            }
            System.out.println("El archivo contiene " + contador + " palabras");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
