import java.io.File;

public class BorrarFichero {
    public static void main(String[] args) {
        File fichero =  new File("data/ficehroAborrar.txt");
        boolean exito = fichero.delete();
        if (exito){
            System.out.println("El fichero se borro");
        }else
            System.out.println("No se borro");
    }
}
