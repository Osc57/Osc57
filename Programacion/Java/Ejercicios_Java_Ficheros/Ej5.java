import java.io.*;

public class Ej5 {
    public static void main(String[] args) {
        String rutaArchivo = "Archivo.txt";
        String archivoNuevo = "ArchivoNuevo.txt";

        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            fileWriter = new FileWriter(archivoNuevo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String linea = null;
            while ((linea = bufferedReader.readLine()) != null){
                bufferedWriter.write(linea.toUpperCase());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
