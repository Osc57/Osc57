import java.io.*;
import java.util.Objects;

public class Ej2 {
    public static void main(String[] args) {
        File directorio = new File("data");

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("salida_Ej2.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (File archivo : directorio.listFiles()){
            try {

                bufferedReader = new BufferedReader(new FileReader(archivo));
                String linea="";

                while ((linea = bufferedReader.readLine()) != null){
                    bufferedWriter.write(linea);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        if (bufferedWriter != null){
            try {
                bufferedWriter.close();
            }catch (IOException e){
                throw new RuntimeException();
            }
        }




    }
}
