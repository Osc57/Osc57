import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    static void main(String[] args) {
        String ip = "127.0.0.1";
        int puerto = 5000;

        try {
            Socket socket = new Socket(ip, puerto);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            Scanner teclado = new Scanner(System.in);

            System.out.println("Conectado al servidor.");
            int opcion = 0;

            while (opcion != 3) {
                System.out.println("\n--- MENÚ ---");
                System.out.println("1. Listar ficheros");
                System.out.println("2. Mostrar fichero");
                System.out.println("3. Salir");
                System.out.print("Elige una opción: ");

                opcion = teclado.nextInt();
                teclado.nextLine(); // Limpiar el "Enter" pendiente del Scanner

                if (opcion == 1) {
                    salida.println("LISTAR");

                    System.out.println("\nArchivos en el servidor:");
                    String linea;
                    while (!(linea = entrada.readLine()).equals("FIN_MENSAJE")) {
                        System.out.println("- " + linea);
                    }

                } else if (opcion == 2) {
                    System.out.print("Escribe el nombre del fichero: ");
                    String nombre = teclado.nextLine();

                    salida.println("MOSTRAR " + nombre);

                    System.out.println("\nContenido del fichero:");
                    String linea;
                    while (!(linea = entrada.readLine()).equals("FIN_MENSAJE")) {
                        System.out.println(linea);
                    }

                } else if (opcion == 3) {
                    salida.println("SALIR");
                    System.out.println("Saliendo del programa...");
                } else {
                    System.out.println("Opción no válida.");
                }
            }

            // Cerramos todo al terminar
            teclado.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("No se pudo conectar con el servidor.");
        }
    }
}

