/*
3. Ejercicio 3 — Ejecutar comandos desde un fichero BAT
Crea un fichero llamado comandos.bat que contenga varios comandos de
consola. Por ejemplo:
echo Comenzando ejecución
date /t
time /t
dir
ipconfig
echo Fin de la ejecución
A continuación, desarrolla un programa Java que utilice ProcessBuilder para
ejecutar dicho fichero .bat.
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej3 {
    static void main() {
        File ficheroSalida = new File("salida.txt");
        File ficheroError = new File("errores.txt");

        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "comandos.bat");
            Process p = pb.start();

            pb.redirectOutput(ficheroSalida);
            pb.redirectError(ficheroError);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line = "";

                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }

                p.waitFor();
                System.out.println("Fin de la ejecución");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
