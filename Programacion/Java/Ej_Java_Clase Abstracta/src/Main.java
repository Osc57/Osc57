import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Legislador> listaLegisladores = new ArrayList<>();
        Diputado diputado = new Diputado("Juan", "18323232K", "Madrid") ;
        Senador senador = new Senador("Robador", "78877887J","Murcia");

        listaLegisladores.add(diputado);
        listaLegisladores.add(senador);

        System.out.println(listaLegisladores);


    }
}
