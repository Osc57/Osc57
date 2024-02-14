import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ej7 {
    public static void main(String[] args) {
        List<Integer> cantidadDeLetra = new ArrayList<>();
        //System.out.println((int)'A');//65
        //System.out.println((int)'Z');//98
        for (int i = 0; i < 27; i++) {
            cantidadDeLetra.add(0);
        }

        String rutaArchivo = "Archivo.txt";

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea = null;
            while ((linea = bufferedReader.readLine()) != null){

               cuentaLetras(linea, cantidadDeLetra);
            }
            System.out.println(cantidadDeLetra.toString());
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void cuentaLetras(String linea, List<Integer> cantidadDeLetra) {
        for (char caracter : linea.toUpperCase().toCharArray()){
            if (Character.isLetter(caracter)){
                int posicionLetra = (int) caracter;
                cantidadDeLetra.set(posicionLetra - 65, cantidadDeLetra.get(posicionLetra-65) + 1);
            }

        }

    }
}

