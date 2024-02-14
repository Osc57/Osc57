import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ej6 {
    public static void main(String[] args) {
        String rutaArchivo = "Archivo.txt";

        FileReader fileReader = null;
        int contadorDeA = 0;
        try {
            fileReader = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea = null;
            while ((linea = bufferedReader.readLine()) != null){
                //Contar el número de veces que aparece la "a"

                for (char caracter : linea.toCharArray()){
                    if (caracter == 'a' || caracter == 'A'){
                        contadorDeA++;
                    }
                }
            }
            System.out.println("En el fichero hay " + contadorDeA + " a");
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

