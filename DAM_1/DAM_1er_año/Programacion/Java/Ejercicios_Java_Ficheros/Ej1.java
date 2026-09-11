import java.io.File;
import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una ruta de fichero: ");
        String ruta = scanner.nextLine();

        File fichero = new File(ruta);

        System.out.println("Directorio raíz: " + File.listRoots()[0]);
        System.out.println("Directorio donde se encuentra el archivo es: " + fichero.getPath());
        System.out.println("Nombre del archivo: " + fichero.getName());

        String nombre = fichero.getName();
        int indice = nombre.lastIndexOf(".");

        if (indice > 0){
            String extension = nombre.substring(indice);
            System.out.println(extension);
        }else
            System.out.println("El archivo no tiene extensión");

        System.out.println("¿El fichero existe?: " + fichero.exists());






        scanner.close();
        }
    }

