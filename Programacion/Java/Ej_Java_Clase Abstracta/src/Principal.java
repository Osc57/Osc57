import java.io.*;

public class Principal {
    public static void main(String[] args) {
        File archivo = new File("ladrones.txt");

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));

            String linea;
            while ((linea = bufferedReader.readLine()) != null){
                System.out.println(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
