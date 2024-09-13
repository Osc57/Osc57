import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PruebaEscritura {
    public static void main(String[] args) {
        {
            File fichero = null;
            FileWriter writer = null;
            PrintWriter pw = null;
            try {
                fichero = new File("data/archivo.txt");
                writer = new FileWriter(fichero);
                pw = new PrintWriter(writer);
                for (int i = 0; i < 10; i++) {
                    pw.println("Linea" + 1);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

