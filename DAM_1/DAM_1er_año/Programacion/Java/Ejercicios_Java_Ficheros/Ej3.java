import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ej3 {
    public static void main(String[] args) {
        String ruta = "./Documentos/PRO_UD8_Ej03/Programacion.txt";
        File archivo = new File(ruta);
        System.out.println("Copiamos un fichero");
        String nombre = archivo.getName();
        int indice = nombre.lastIndexOf(".");
        //System.out.println(nombreSinExtension);
        String extension = nombre.substring(indice);
        //System.out.println(extension);

        try {
            Path source = Path.of(ruta);
            Files.copy(source, Path.of(ruta + "(+1)" + extension));
            Files.copy(source, Path.of(ruta + "(+2)" + extension));
            if (archivo.exists()){
                System.out.println("Se ha copiado con existo");
            }else if (archivo.exists());
                System.out.println("El archivo ya existe");
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
