import java.io.*;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        File archivo = new File("ladrones.txt");

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));

            String linea;
            while ((linea = bufferedReader.readLine()) != null){
                list.add(linea);
            }
            System.out.println(list);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
