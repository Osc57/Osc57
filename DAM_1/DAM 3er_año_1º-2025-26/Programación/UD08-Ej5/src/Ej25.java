/*
25. Contar las líneas que contienen una palabra específica. Desarrolla un
programa que lea un archivo de texto y muestre cuántas líneas contienen una
palabra específica que el usuario debe introducir.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una palabra para comprobar en cuantas lineas esta: ");
        String palabra = scanner.next();

        Pattern pattern = Pattern.compile("\\b" + palabra + "\\b");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"))) {
            int contador = 0;
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(linea);

                if (matcher.find()) {
                    contador++;
                }
            }

            System.out.println("La palabra esta en " + contador + " lineas");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
