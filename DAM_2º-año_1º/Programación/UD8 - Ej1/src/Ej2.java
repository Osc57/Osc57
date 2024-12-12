import java.io.File;
import java.util.Scanner;

/**
 * Crea un programa que pida al usuario introducir una ruta del directorio de
 * archivos del ordenador. A continuación, el programa debe mostrar cuál es la
 * ruta de la subcarpeta que contiene el archivo o el directorio. También debe
 * mostrar si la ruta existe realmente en el ordenador y, en caso de existir, debe
 * mostrar si se trata de un fichero o un directorio. En el caso de que se trate de
 * un directorio el programa mostrará también el contenido de dicho directorio.
 **/
public class Ej2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime la ruta del directorio de archivos del ordenador: ");
        String ruta = scanner.nextLine();

        File file = new File(ruta);

        
    }
}
