package org.example.SegundaEvaluacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej2 {
    public static void main(String[] args) {

        String regex = "[A-Za-z]*\\s*[!?¿'.,&%$:;\\-_+/*¡]*(data)\\s*[!?¿'.,&%$:;\\-_+/*¡]*[A-Za-z]*";
        int contador = 0;

        Pattern pattern = Pattern.compile(regex);


        try (BufferedReader br = new BufferedReader(new FileReader("DataAnalysis.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(" ");

                for (String p : palabras) {
                    String palabra = p.toLowerCase().trim();
                    Matcher matcher = pattern.matcher(palabra);

                    if (matcher.find()) {
                        contador++;
                    }

                }
            }

            System.out.println("Hay " + contador + " palabras que contienen la subcadena 'data'");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
