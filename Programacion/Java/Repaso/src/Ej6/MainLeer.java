package Ej6;

import java.io.*;

public class MainLeer {
    public static void main(String[] args) {
        String linea;
        File archivo = new File("puteros.txt");

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
            while ((linea = bufferedReader.readLine()) != null){
                System.out.println(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
