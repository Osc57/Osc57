package Ej3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej3 {
    public static void main(String[] args) {
            String contenido = null;

        {
            try {
                contenido = new String(Files.readAllBytes(Paths.get("./src/Ej3/Languages for Data Science.txt")));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Pattern pattern = Pattern.compile("\\b\\w*s\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(contenido);

            int contador = 0;
            while (matcher.find()){
                contador++;
            }
            System.out.println("Número de palabras = " + contador);
        }
    }

}
