import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ej4 {
    public static void main(String[] args) {
        String rutaArchivo = "Archivo.txt";

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea = null;
            while ((linea = bufferedReader.readLine()) != null){
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
