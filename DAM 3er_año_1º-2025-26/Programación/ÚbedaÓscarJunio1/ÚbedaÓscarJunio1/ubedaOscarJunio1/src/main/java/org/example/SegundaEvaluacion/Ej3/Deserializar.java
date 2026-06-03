package org.example.SegundaEvaluacion.Ej3;

import java.io.*;

public class Deserializar {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("empleados.dat"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
