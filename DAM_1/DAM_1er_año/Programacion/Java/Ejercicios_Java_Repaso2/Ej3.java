import java.io.*;
import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        String ruta = "indices.txt";
        File archivoIndices = new File(ruta);

        String rutaSalida = "indices.txt";
        File archivoSQL = new File(rutaSalida);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre de la tabla: ");
        String tabla = scanner.nextLine();
        BufferedWriter bufferedWriter = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(archivoIndices));
            bufferedWriter = new BufferedWriter(new FileWriter(archivoSQL));

                archivoSQL.createNewFile();
                String linea = "";
                while ((linea = bufferedReader.readLine()) != null){
                    int id_de_linea = Integer.parseInt(bufferedReader.readLine());
                    bufferedWriter.write("delete from " + tabla + " where id = " + id_de_linea);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
