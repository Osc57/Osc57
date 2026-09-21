import java.io.IOException;

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
