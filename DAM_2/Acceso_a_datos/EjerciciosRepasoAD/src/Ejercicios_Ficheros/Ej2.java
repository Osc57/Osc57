package Ejercicios_Ficheros;

/*
2 Copiar un archivo: Escribir un programa en Java que copie el contenido de un archivo en
otro archivo. El programa debe tomar como entrada el nombre del archivo de origen y el
nombre del archivo de destino
*/

import java.io.*;

public class Ej2 {
    static void main() {

        try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("archivoCopia.txt"))) {


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
