package Ejercicios_Ficheros;

/*
1 Contar el número de líneas en un archivo: Escribir un programa en Java que lea un
archivo de texto y cuente el número de líneas que contiene. El programa debe imprimir el
número de líneas en la consola.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej1 {
    static void main() {

        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contador++;
            }

            System.out.println("El archivo contiene " + contador + " lineas");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
