/*
1. Ejercicio 1 — Abrir una aplicación con ProcessBuilder
Crea un programa en Java que utilice ProcessBuilder para lanzar una
aplicación instalada en tu ordenador.
El programa deberá:
• Solicitar al usuario mediante teclado la ruta del programa que desea
ejecutar.
• Crear un proceso utilizando ProcessBuilder.
• Esperar a que el proceso termine mediante waitFor().
• Mostrar por consola el código de finalización del proceso.
• Controlar las posibles excepciones que puedan producirse.
Ejemplo: puedes probarlo ejecutando el Bloc de notas (notepad.exe) o la
calculadora de Windows.
*/


import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ej1 {
    static void main() {
        //"C:\Program Files\Notepad++\notepad++.exe"
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame la ruta del programa que deseas ejecutar: ");
        String ruta = sc.nextLine();

        if (esRutaValida(ruta)) {
            ProcessBuilder pb = new ProcessBuilder(ruta);
            try {
                Process p = pb.start();
                int codigoSalida = p.waitFor();

                System.out.println("Proceso Finalizado " + codigoSalida);
            } catch (IOException | InterruptedException e) {
                System.out.println("Ruta invalida " + e.getMessage());
            }
        } else {
            System.out.println("Introduce una ruta válida");
        }
    }

    public static boolean esRutaValida(String ruta) {
        try {
            Paths.get(ruta);
            return true;
        } catch (InvalidPathException | NullPointerException e) {
            return false;
        }
    }
}
