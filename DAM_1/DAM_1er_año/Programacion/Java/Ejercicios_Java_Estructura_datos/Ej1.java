import java.util.ArrayList;

public class Ej1 {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();

        lista.add("Fiat");
        lista.add("Porche");
        lista.add("Renault");
        lista.add("BMW");
        lista.add("Peugeot");

        imprimeLaLista(lista);
        //Añado un elemento en una posición específica
        lista.add(2, "Ferrari");
        imprimeLaLista(lista);

        //Elimino un elemento por valor
        lista.remove("BMW");
        imprimeLaLista(lista);

        //Elimino un elemento por índice (Elimino la posición 2)
        lista.remove(2);
        imprimeLaLista(lista);


    }

    private static void imprimeLaLista(ArrayList<String> lista) {
        System.out.print("\n");
        for (String coche : lista){
            System.out.print(coche + ", ");
        }
        System.out.print("\n");
    }
}
