import java.io.*;

public class Ej1 {
    public static void main(String[] args) {
     String ruta = "data/Archivo.txt";
     BufferedReader bufferedReader = null;
     int contadorPalabras = 0;

        try {
            bufferedReader = new BufferedReader(new FileReader(ruta));
            String linea = bufferedReader.readLine();

            while (linea != null){
                String[] palabras = linea.split("");
                contadorPalabras = contadorPalabras + palabras.length;
                //contadorPalabras += palabras.length;
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
