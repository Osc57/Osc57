import java.io.File;

public class Ej2 {
    public static void main(String[] args) {
        String ruta = "D:\\Users\\dam1\\Desktop\\comando.txt";
        File fichero = new File(ruta);

        System.out.println("La ruta: " + fichero.getParent());
        System.out.println("¿Existe?: " + fichero.exists());
        System.out.println("¿Fichero?: " + fichero.isFile());
        System.out.println("¿Directorio?: " + fichero.isDirectory());

        System.out.println("\n Listamos en contenido");
        if (fichero.isDirectory()){
            for (String archivo : fichero.list()){
                System.out.println(archivo);
            }
        }



    }
}
