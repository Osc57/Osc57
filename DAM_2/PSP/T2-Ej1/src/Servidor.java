import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 5000;
        String carpetaTrabajo = "./archivos_servidor";

        // Creamos la carpeta y un archivo de prueba si no existen
        File carpeta = new File(carpetaTrabajo);
        if (!carpeta.exists()) {
            carpeta.mkdir();
            try {
                PrintWriter escritor = new PrintWriter(new File(carpeta, "nota.txt"));
                escritor.println("Hola mundo.");
                escritor.println("Este es un archivo de prueba.");
                escritor.close();
            } catch (IOException e) {
                System.out.println("No se pudo crear el archivo de prueba.");
            }
        }

        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor encendido en el puerto " + puerto + "...");

            // Bucle infinito para aceptar muchos clientes
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("¡Nuevo cliente conectado!");

                // Arrancamos un hilo nuevo para atender a este cliente
                HiloCliente hilo = new HiloCliente(cliente, carpetaTrabajo);
                hilo.start();
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}

