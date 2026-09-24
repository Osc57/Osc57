/*
 2. Hemos visto en los ejemplos que podemos lanzar un proceso con
ProcessBuilder y ejecutar comandos de consola (cmd) en él. En el ejemplo
indicábamos exactamente el comando a ejecutar y mostrábamos por consola
el resultado de la ejecución. La clase ProcessBuilder permite redirigir la
entrada, salida y los errores en la ejecución de proceso a ficheros. Busca
información en la ayuda de Java sobre los métodos redirectInput,
redirectOutput y redirectError. Deberás desarrollar un programa que lance un
subproceso cmd con ProcessBuilder, el programa debe obtener los comandos
a ejecutar por la consola de un fichero .bat que habrás creado tú
previamente. El programa dejará el log de ejecución en un fichero de salida y
el log de errores en otro fichero. Deberás utilizar los métodos redirectInput,
redirectOutput y redirectError.
El fichero bat podría tener por ejemplo los siguientes comandos:
ping www.dam2chomon.org
ping www.google.es
pring www.iesch.org
De esa forma veremos que ocurre en cada situación:
• un comando correcto con una dirección que no existe
• un comando correcto con una dirección que existe
• un comando incorrecto
 */

import java.io.File;
import java.io.IOException;

public class Ej2 {
    static void main(String[] args) {
        File ficheroEntrada = new File("comandos.bat");
        File ficheroSalida = new File("salida.log");
        File ficheroError = new File("error.log");

        if (!ficheroEntrada.exists()) {
            System.err.println("Error: El fichero 'comandos.bat' no existe en la raíz del proyecto.");
            return;
        }
        ProcessBuilder pb = new ProcessBuilder("cmd.exe");

        pb.redirectInput(ficheroEntrada);
        pb.redirectOutput(ficheroSalida);
        pb.redirectError(ficheroError);

        try {
            System.out.println("Iniciando el subproceso cmd...");

            Process proceso = pb.start();

            int codigoSalida = proceso.waitFor();

            System.out.println("Proceso finalizado de forma segura.");
            System.out.println("Código de salida del sistema: " + codigoSalida);
            System.out.println("Verifica 'salida.log' y 'error.log' para ver los resultados.");

        } catch (IOException e) {
            System.err.println("Error de Entrada/Salida: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("El proceso fue interrumpido de forma inesperada: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}

