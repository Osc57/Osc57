package Ej3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainEj2 {
    public static void main(String[] args) {
        List<Legislador> list = new ArrayList<>();

        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("ladrones.txt"));

            for (Legislador legislador : list) {
                //System.out.println(legislador.toString());
                bufferedWriter.write(legislador.toString());
                bufferedWriter.flush();

            }
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException();
        }finally {
            if (bufferedWriter != null){
                try {
                    bufferedWriter.close();
                }catch (IOException e){
                    throw new RuntimeException();
                }
            }
        }

    }

}
