import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class Ej3 {
    public static void main(String[] args) {
        Path path = Path.of("Metadata in DBMS.txt");
        String contenido = null;

        try {
            contenido = Files.readString(path).toLowerCase().replace(":", "")
                    .replace(".","").replace(",","")
                    .replace("\r"," ").replace("\n"," ")
                    .replace("\n\r"," ").replace("  "," ");

            String[] palabras = contenido.split(" ");
            Map<String, Integer> palabrasRepetidas = new TreeMap<>();

            for (String palabra : palabras){
                if (palabrasRepetidas.containsKey(palabra)){
                    palabrasRepetidas.put(palabra, palabrasRepetidas.get(palabra) + 1);
                }else {
                    palabrasRepetidas.put(palabra, 1);
                }

            }
            System.out.println(palabrasRepetidas);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
