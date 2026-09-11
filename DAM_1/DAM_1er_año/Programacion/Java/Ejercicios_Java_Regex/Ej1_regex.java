import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Ej1_regex {
    public static void main(String[] args) {
        String ruta = "data/Archivo.txt";
        BufferedReader bufferedReader = null;
        int contadorPalabras = 0;


        try {
            bufferedReader = new BufferedReader(new FileReader(ruta));
            String linea = bufferedReader.readLine();

            while (linea != null){
                String[] palabras = Pattern.compile("\\s+").split(linea);
                contadorPalabras = contadorPalabras + palabras.length;

                linea = bufferedReader.readLine();
            }
            System.out.println("El archivo contiene " + contadorPalabras);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}


