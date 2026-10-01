
/*
4. Ejercicio 4 — Redirección de entrada desde un fichero
Crea un fichero de texto llamado comandos.txt que contenga diferentes
comandos que puedan ejecutarse desde cmd, por ejemplo:
echo Inicio
hostname
whoami
ipconfig
echo Fin
Desarrolla un programa Java que cree un proceso cmd mediante ProcessBuilder.
En lugar de proporcionar los comandos directamente desde Java, el proceso
deberá obtenerlos mediante la entrada estándar redirigida desde el fichero
comandos.txt.
El programa deberá:
• Utilizar redirectInput() para indicar el fichero de entrada.
• Utilizar redirectOutput() para guardar la salida en resultado.txt.
• Utilizar redirectError() para guardar los errores en errores.txt.
• Esperar a que termine el proceso.
• Mostrar el código de finalización por consola.
Objetivo: comprobar cómo se pueden utilizar ficheros como entrada y salida de
un proceso.
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej4 {
    public static void main(String[] args) {
        File ficheroEntrada = new File("comandos.txt");
        File ficheroResultado = new File("resultado.txt");
        File ficheroErrores = new File("errores.txt");

        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe");

            pb.redirectInput(ficheroEntrada);
            pb.redirectOutput(ficheroResultado);
            pb.redirectError(ficheroErrores);

            System.out.println("Iniciando el proceso cmd...");
            Process p = pb.start();

            int exitCode = p.waitFor();

            System.out.println("El proceso ha terminado.");
            System.out.println("Código de finalización: " + exitCode);

        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("El proceso fue interrumpido: " + e.getMessage());
            Thread.currentThread().interrupt(); 
        }
    }
}
