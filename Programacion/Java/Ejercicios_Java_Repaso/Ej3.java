
import java.util.ArrayList;
import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        System.out.print("Cuantos números quieres meter a la lista: ");
        int interfaz = scanner.nextInt();

        for (int i = 0; i < interfaz; i++) {
            System.out.print("Dime un número: ");
            int numeros = scanner.nextInt();
            lista.add(numeros);

        }

        lista.add(-1);
        System.out.println("Esta es tu lista: " + lista);
        while (true){
            System.out.print("Quieres quitarle los duplicados Y/N: ");
            String si_no = scanner.next();

            if (si_no.equals("Y") || si_no.equals("y")) {
                ArrayList<Integer> listaSinDuplicados = new ArrayList<>();
                for (int i = 0; i < lista.size(); i++) {
                    int numero = lista.get(i);

                    if (!listaSinDuplicados.contains(numero)) {
                        listaSinDuplicados.add(numero);
                    }
                }
                System.out.println("Lista sin duplicados: " + listaSinDuplicados);
                break;
            } else if (si_no.equals("N") || si_no.equals("n")) {
                System.out.println("Has decidido no cambiar la lista, y se queda asi: " + lista);
                break;
            } else {
                System.out.println("Error, intentalo de nuevo");
            }
        }


        }
    }


