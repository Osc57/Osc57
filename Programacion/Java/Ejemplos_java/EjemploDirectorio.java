import javax.swing.plaf.FileChooserUI;
import java.io.File;

public class EjemploDirectorio {
    public static void main(String[] args) {
        File file = new File("./data");
        if (file.exists()){
            System.out.println("Existe");
        }else {
            System.out.println("No existe");
            System.out.println("Vamos a crearlo");
            boolean fueBien = file.mkdirs();
            if (fueBien){
                System.out.println("Creado");
            }else {
                System.out.println("Dio Error");
            }
        }
    }
}
