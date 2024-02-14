import java.io.*;

public class PruebaFichero {
    public static void main(String[] args) {
        File fichero = new File("data/Hola.txt");
        //if(fichero.exists()){
            //System.out.println(fichero.getAbsolutePath());
            //System.out.println(fichero.canRead());
            //System.out.println(fichero.getName());
        //}

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fichero);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea = null;
            while ((linea = bufferedReader.readLine()) != null) {

                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("No puedo leer el fichero");
            throw new RuntimeException(e);
        }


    }


}
