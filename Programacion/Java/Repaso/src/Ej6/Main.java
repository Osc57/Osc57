package Ej6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Putero> puteros = new ArrayList<>();

        puteros.add(new Putero("Javier", "45859665E", 635566998));
        puteros.add(new Putero("Pedro", "12345678A", 666668986));
        puteros.add(new Putero("Maria", "12345678B", 666666666));

        File file = new File("Data/puteros.txt");

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            for (Putero putero : puteros) {
                bufferedWriter.write(putero.toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
