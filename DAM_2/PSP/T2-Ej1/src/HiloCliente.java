import java.io.*;
import java.net.Socket;

public class HiloCliente extends Thread {
    private Socket socket;
    private String rutaCarpeta;

    public HiloCliente(Socket socket, String rutaCarpeta) {
        this.socket = socket;
        this.rutaCarpeta = rutaCarpeta;
    }

    @Override
    public void run() {
        try {
            // Flujos para leer y escribir texto de forma eficiente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            String peticion;
            // Leemos lo que pide el cliente hasta que se desconecte
            while ((peticion = entrada.readLine()) != null) {

                if (peticion.equals("LISTAR")) {
                    File carpeta = new File(rutaCarpeta);
                    File[] archivos = carpeta.listFiles();

                    if (archivos != null && archivos.length > 0) {
                        for (File f : archivos) {
                            if (f.isFile()) {
                                salida.println(f.getName());
                            }
                        }
                    } else {
                        salida.println("La carpeta está vacía.");
                    }
                    // Marca para que el cliente sepa que ya terminamos de enviar líneas
                    salida.println("FIN_MENSAJE");

                } else if (peticion.startsWith("MOSTRAR ")) {
                    // Quitamos la palabra "MOSTRAR " para quedarnos solo con el nombre
                    String nombreArchivo = peticion.substring(8).trim();
                    File archivo = new File(rutaCarpeta, nombreArchivo);

                    if (archivo.exists() && archivo.isFile()) {
                        // Leemos el archivo línea a línea (muy eficiente en memoria)
                        BufferedReader lectorArchivo = new BufferedReader(new FileReader(archivo));
                        String linea;
                        while ((linea = lectorArchivo.readLine()) != null) {
                            salida.println(linea);
                        }
                        lectorArchivo.close();
                    } else {
                        salida.println("Error: El archivo '" + nombreArchivo + "' no existe.");
                    }
                    salida.println("FIN_MENSAJE");

                } else if (peticion.equals("SALIR")) {
                    break; // Salimos del bucle para cerrar la conexión
                }
            }

            socket.close();
            System.out.println("Cliente desconectado.");

        } catch (IOException e) {
            System.out.println("Error con un cliente: " + e.getMessage());
        }
    }
}
