import java.io.File;
import java.util.Scanner;

/**
 * Crea programa que permita introducir la ruta de un fichero y muestre:
 * • El directorio raíz del sistema de archivos que contiene el archivo.
 * • El directorio donde se encuentra el archivo.
 * • El nombre del archivo.
 * • La extensión del archivo.
 * • Si el fichero existe o no en el sistema de ficheros del ordenador.
 **/
public class Ej1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime la ruta de tu archivo: ");
        String ruta = scanner.nextLine();

        File file = new File(ruta);

        System.out.println("Directorio raíz: " + file.toPath().getRoot());
        System.out.println("Nombre del archivo: " + file.getName());

        String archivoNombre = file.getName();
        int extension = archivoNombre.lastIndexOf('.');

        if (extension > 0 && extension < archivoNombre.length() - 1) {
            System.out.println("Extensión del archivo: " + archivoNombre.substring(extension + 1));
        } else {
            System.out.println("El archivo no tiene extensión");
        }

        if (file.exists()) {
            System.out.println("El archivo existe");
        } else {
            System.out.println("El archivo no existe");
        }

        scanner.close();

    }
}
