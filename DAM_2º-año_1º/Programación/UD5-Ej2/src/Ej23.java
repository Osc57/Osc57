import java.io.File;
import java.util.Scanner;

/**
 * A partir del nombre completo de un fichero obtener:
 * - path del directorio donde está
 * - nombre del fichero
 * - extensión
 * Por ejemplo:
 * Nombre completo: /home/dam/Documents/UD05_Ejercicios.pdf
 * Deberemos obtener:
 * - path: /home/dam/Documents/
 * - nombre del fichero: UD05_Ejercicios
 * - extensión: pdf
 * **/
public class Ej23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una ruta de fichero: ");
        String ruta = scanner.nextLine();

        int path = ruta.lastIndexOf('/');
        int direccion = ruta.indexOf('/');
        System.out.println(direccion);
        if (direccion == 0){
            String r = ruta.substring(direccion);
            System.out.println(r);
        }

        if (path > 0){
            String fichero = ruta.substring(path);
            System.out.println("Nombre del fichero: " + fichero);
        }






        scanner.close();

    }
}
