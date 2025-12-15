/*
3. Crea en la carpeta Documentos de tu ordenador una subcarpeta llamada
PRO_UD08_Ej03. Crea manualmente un fichero de texto llamado
Programacion.txt con el siguiente contenido:
*/

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ej3 {
    public static void main(String[] args) {
        /*
        a) Copie el archivo Programacion.txt que se encuentra en la carpeta
        PRO_UD08_Ej03 y lo pegue dos veces en la misma carpeta con los
        nombres Programacion(+1).txt y Programacion(+2).txt
        */

        String ruta = "Documentos/PRO_UD08_Ej03/Programacion.txt";
        File archivo = new File(ruta);

        String nombre = archivo.getName();
        int indice = nombre.lastIndexOf(".");

        String extension = nombre.substring(indice);

        try {
            Path source = Path.of(ruta);
            Files.copy(source, Path.of(ruta + "(+1)" + extension));
            Files.copy(source, Path.of(ruta + "(+2)" + extension));
            if (archivo.exists()) {
                System.out.println("Se ha copiado con existo");
            }
        } catch (IOException e) {
            System.out.println("Los archivos [Programacion.txt] ya están copiados, ERROR [" + e + "]");
        }

        /*
        b) Cree dentro de la carpeta PRO_UD08_Ej03 la siguiente estructura de
         carpetas: /docs/samples
         */
        File carpetaSamples = new File("Documentos/PRO_UD08_Ej03/docs/samples");

        if (!carpetaSamples.exists()) {
            if (carpetaSamples.mkdirs()) {
                System.out.println("Directorio /docs/samples creado");
            } else {
                System.out.println("Error al crear el directorio");
            }
        } else {
            System.out.println("Las Carpetas /docs/samples ya estan creadas");
        }

        /*
        c) Cree dentro de la carpeta PRO_UD08_Ej03 la siguiente estructura de
        carpetas: /docs/exercises
         */
        

    }
}
