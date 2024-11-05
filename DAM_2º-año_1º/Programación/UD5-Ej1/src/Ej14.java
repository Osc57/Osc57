import java.util.Scanner;

/**
 * Pueblos de Aragón. El programa mostrará al usuario las siguientes opciones:
 * **/
public class Ej14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * a) Mostrar pueblos por provincia. Pedirá al usuario que elija la provincia:
         * Huesca, Teruel, Zaragoza. Después mostrará todos los pueblos de la
         * provincia ordenados por orden alfabético.
         * **/
        System.out.print("Elije la provincia (Huesca,Teruel,Zaragoza): ");
        String provincia = scanner.next().toLowerCase();

        if (provincia.equals("huesca")){
            System.out.println("hola");
        }

    }
}
