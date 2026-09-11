import java.util.Arrays;
import java.util.Scanner;

/**
 * Pueblos de Aragón. El programa mostrará al usuario las siguientes opciones:
 * **/
public class Ej14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] huesca = {"Ayerbe", "Jaca", "Alquézar", "Sabiñánigo"};
        String [] teruel = {"Albarracín", "Andorra", "Calamocha", "Teruel"};
        String [] zaragoza = {"Zaragoza", "Ejea de los Caballeros", "Cuarte de Huerva", "La Almunia de Doña Godina"};
        /**
         * a) Mostrar pueblos por provincia. Pedirá al usuario que elija la provincia:
         * Huesca, Teruel, Zaragoza. Después mostrará todos los pueblos de la
         * provincia ordenados por orden alfabético.
         * **/
        System.out.print("Elije la provincia (Huesca,Teruel,Zaragoza): ");
        String provincia = scanner.next().toLowerCase();

        if (provincia.equals("huesca")){
            Arrays.sort(huesca);
            System.out.println("•Pueblos de Huesca ordenados alfabéticamente");
            for (String pueblo : huesca){
                System.out.print(pueblo + " ");
            }
        } else if (provincia.equals("teruel")) {
            Arrays.sort(teruel);
            System.out.println("•Pueblos de Teruel ordenados alfabéticamente");
            for (String pueblo : teruel){
                System.out.print(pueblo + " ");
            }
        } else if (provincia.equals("zaragoza")) {
            Arrays.sort(zaragoza);
            System.out.println("•Pueblos de Zaragoza ordenados alfabéticamente");
            for (String pueblo : zaragoza){
                System.out.print(pueblo + " ");
            }
        }else {
            System.out.println("ERROR: has introducido la provincia mal");
        }

        /**
         * b) Introducir pueblos por provincia. Pedirá al usuario que elija la
         * provincia: Huesca, Teruel, Zaragoza. Después pedirá al usuario el
         * número de pueblos de la provincia elegida que va a introducir y, a
         * continuación, pedirá que los introduzca. Una vez introducidos añadirá
         * los nuevos pueblos a la lista de pueblos de la provincia de seleccionada
         * validando que no hay duplicados.
         * **/

    }
}
