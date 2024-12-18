import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Crea en la carpeta Documentos de tu ordenador una subcarpeta llamada
 * PRO_UD08_Ej03. Crea manualmente un fichero de texto llamado
 * Programacion.txt con el siguiente contenido:
 **/
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
            } else if (archivo.exists()) ;
            System.out.println("El archivo ya existe");
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
        File carpetaExercises = new File("Documentos/PRO_UD08_Ej03/docs/exercises");

        if (!carpetaExercises.exists()) {
            if (carpetaExercises.mkdirs()) {
                System.out.println("Directorio creado /docs/exercises creado");
            } else {
                System.out.println("Error al crear el directorio");
            }
        } else {
            System.out.println("Las carpetas /docs/exercises ya estan creadas");
        }

        /*
        d) Copie el archivo Programacion.txt en la carpeta
        /PRO_UD08_Ej03/docs/samples
         */
        Path source = Paths.get("Documentos/PRO_UD08_Ej03/Programacion.txt");

        Path objetivo = Paths.get("Documentos/PRO_UD08_Ej03/docs/samples/ProgramacionCopia.txt");


        try {
            Files.copy(source, objetivo, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Archivo copiado correctamente");
        } catch (IOException e) {
            System.out.println("El archivo ya esta copiado en la carpeta /docs/samples, ERROR [" + e + "]");;
        }

        /*
        e) Mueva el archivo Programacion.txt de /PRO_UD08_Ej03 a la carpeta
        /PRO_UD08_Ej03/docs/exercises
         */
        Path inicio = Path.of(String.valueOf(source));

        Path rutaExercises = Paths.get("Documentos/PRO_UD08_Ej03/docs/exercises/Programacion.txt");

        try{
            Files.move(inicio, rutaExercises, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Archivo movido correctamente");
        } catch (IOException e) {
            System.out.println("El archivo ya esta movido a la carpeta /docs/exercises, ERROR [" + e + "]");
        }


        /*
        f) Renombre el fichero Programacion(+1).txt como Programacion.txt en
        /PRO_UD08_Ej03
         */
        Path renombrarFichero = Paths.get("Documentos/PRO_UD08_Ej03/Programacion.txt(+1).txt");


        try {
            Files.move(renombrarFichero, source, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Archivo renombrado");
        } catch (IOException e) {
            System.out.println("El archivo ya a sido renombrado, ERROR [" + e + "]");
        }

        /*
        g) Borre el archivo Programacion(+2).txt que se encuentra en la carpeta
        /PRO_UD08_Ej03.
         */
        File eliminarArchivo = new File("Documentos/PRO_UD08_Ej03/Programacion.txt(+2).txt");

        if (eliminarArchivo.delete()){
            System.out.println("Archivo eliminado: " + eliminarArchivo.getName());
        }else {
            System.out.println("Fallo al eliminar el archivo");
        }

    }
}
