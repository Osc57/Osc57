import java.lang.reflect.Array;
import java.util.*;

public class Ej4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();

        System.out.print("Cuantas palabras quieres meter a la lista: ");
        int interfaz = scanner.nextInt();

        for (int i = 0; i < interfaz; i++) {
            System.out.print("Dime una serie de palabras: ");
            String palabras = scanner.next();
            lista.add(palabras);
        }
        System.out.println("Esta es tu lista: " + lista);

        while (true){
            System.out.print("Quieres ordenar la lista alfabéticamente Y/N: ");
            String si_no = scanner.next();

            if (si_no.equals("Y") || si_no.equals("y")) {
                Collections.sort(lista);
                System.out.println("Lista ordenada: " + lista);
                break;
            } else if (si_no.equals("N") || si_no.equals("n")) {
                System.out.println("Has decidido no ordenar la lista, y se queda asi: " + lista);
                break;
            } else {
                System.out.println("Error, intentalo de nuevo");
            }
        }
        while (true){
            System.out.print("Quieres buscar una palabra en la lista Y/N: ");
            String si_no = scanner.next();

            if (si_no.equals("Y") || si_no.equals("y")) {
                System.out.print("Que palabra quieres buscar: ");
                String word = scanner.next();

                if (lista.contains(word)){
                    int posicion = lista.indexOf(word);
                    System.out.print("La palabra está y se encuentra en la posición: " + posicion);
                }
                break;
            } else if (si_no.equals("N") || si_no.equals("n")) {
                System.out.println("Has decidido no buscar la palabra");
                break;
            } else {
                System.out.println("Error, intentalo de nuevo");
            }
        }




    }
}
