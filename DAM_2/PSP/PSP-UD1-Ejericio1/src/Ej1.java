import java.io.IOException;

/*
1. Crea un archivo de texto con la carpeta Documentos de tu ordenador. Crea un
programa en java que lance un proceso para abrir este fichero con
Notepad++.
*/

public class Ej1 {
    static void main() {
        String rutaDoc = "C:\\Users\\dam2\\Documents\\archivo.txt";
        String rutaNotepad = "\"C:\\Program Files\\Notepad++\\notepad++.exe\"";


        try {
            ProcessBuilder processBuilder = new ProcessBuilder(rutaNotepad, rutaDoc);

            Process p = processBuilder.start();

            p.waitFor();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
