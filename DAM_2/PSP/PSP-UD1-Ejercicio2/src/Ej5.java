/*
5. Ejercicio 5 — Lanzamiento de varios procesos
Crea un programa Java que lance tres procesos independientes utilizando
ProcessBuilder.
Cada proceso deberá ejecutar un comando diferente de Windows:
• Proceso 1: mostrar la configuración de red mediante ipconfig.
• Proceso 2: mostrar el nombre del equipo mediante hostname.
• Proceso 3: realizar un ping a www.google.es.
Cada proceso deberá guardar su resultado en un fichero diferente:
ipconfig.txt
hostname.txt
ping.txt
El programa deberá:
• Crear los tres objetos ProcessBuilder.
• Lanzar los tres procesos.
• Redirigir la salida de cada proceso a su correspondiente fichero.
• Esperar a que terminen los tres procesos utilizando waitFor().
• Mostrar por consola el código de finalización de cada uno.
• Controlar las excepciones que puedan producirse.
Ampliación: modifica el programa para que los tres procesos se lancen antes de
esperar a que termine cualquiera de ellos. De esta forma podrás observar que los
procesos pueden ejecutarse de forma concurrente.
*/

import java.io.File;
import java.io.IOException;

public class Ej5 {
    static void main() {
        File ficheroIpConfig = new File("ipconfig.txt");
        File ficheroHostName = new File("hostname.txt");
        File ficheroPing = new File("ping.txt");

        try {
            ProcessBuilder pb1 = new ProcessBuilder("cmd.exe", "/c", "ipconfig");
            ProcessBuilder pb2 = new ProcessBuilder("cmd.exe", "/c", "hostname");
            ProcessBuilder pb3 = new ProcessBuilder("cmd.exe", "/c", "ping www.google.es");

            pb1.redirectOutput(ficheroIpConfig);
            pb2.redirectOutput(ficheroHostName);
            pb3.redirectOutput(ficheroPing);


            System.out.println("Iniciando el proceso cmd...");
            Process p1 = pb1.start();
            Process p2 = pb2.start();
            Process p3 = pb3.start();

            p1.waitFor();
            p2.waitFor();
            p3.waitFor();

            System.out.println("El proceso ha terminado.");

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
