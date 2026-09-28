/*
2. Ejercicio 2 — Ejecutar comandos y guardar la salida en un fichero
Crea un programa Java que lance un proceso cmd utilizando ProcessBuilder.
El programa deberá ejecutar varios comandos de Windows, por ejemplo:
echo Usuario actual:
whoami
echo Directorio actual:
cd
echo Contenido del directorio:
dir
La salida producida por estos comandos deberá almacenarse en un fichero
llamado salida.txt.
Además:
• Los errores deberán almacenarse en un fichero llamado errores.txt.
• Deberás utilizar redirectOutput() y redirectError().
• El programa deberá esperar a que finalice el proceso.
• Finalmente, deberá mostrar por consola el código de finalización.
*/

import java.io.*;

public class Ej2 {
    static void main() {
        File ficheroEntrada = new File("ficheroEntrada.bat");
        File ficheroSalida = new File("salida.txt");
        File ficheroError = new File("errores.txt");

        if (!ficheroEntrada.exists()) {
            System.out.println("No existe el fichero de entrada");
            try {
                ficheroEntrada.createNewFile();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("ficheroEntrada.bat"));
                     BufferedReader br = new BufferedReader(new FileReader("comandos.txt"))) {

                    String line;

                    while ((line = br.readLine()) != null) {
                        bw.write(line);
                        bw.newLine();
                    }
                    System.out.println("Fichero creado con comandos");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }

        ProcessBuilder pb = new ProcessBuilder("cmd.exe");

        pb.redirectInput(ficheroEntrada);
        pb.redirectOutput(ficheroSalida);
        pb.redirectError(ficheroError);

        try {
            Process p = pb.start();
            p.waitFor();

            System.out.println("Proceso finalizado");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
