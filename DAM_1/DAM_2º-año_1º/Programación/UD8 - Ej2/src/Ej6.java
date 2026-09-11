import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Desarrolla un programa que lea un archivo un archivo de texto y muestre el
 * número de veces que aparece la letra ‘a’.
 **/
public class Ej6 {
    public static void main(String[] args) {

        int cuentaA = 0;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("archivo.txt"))){

            String linea;

            while ((linea = bufferedReader.readLine()) != null){
                for (char letra : linea.toCharArray()){
                    if (letra == 'a' || letra == 'A'){
                        cuentaA++;
                    }
                }
            }

            System.out.println("El total de letras 'a' son: " + cuentaA);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
