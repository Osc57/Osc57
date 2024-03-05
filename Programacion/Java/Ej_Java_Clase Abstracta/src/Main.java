import java.util.ArrayList;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArrayList<Legislador> listaLegisladores = new ArrayList<>();

        Diputado diputado = new Diputado();
        diputado.setNombre("Abalos");
        diputado.setDNI("17452215Y");
        diputado.setProvinciaQueRepresenta("Valencia");
        diputado.setPartidoPolitico("PSOE");

        Diputado diputado2 = new Diputado();
        diputado2.setNombre("Tania Sanchez");
        diputado2.setDNI("15468595Y");
        diputado2.setPartidoPolitico("Potemos");
        diputado2.setProvinciaQueRepresenta("Madrid");

        Diputado diputado3 = new Diputado();
        diputado3.setNombre("Herminio Sancho");
        diputado3.setDNI("18444555H");
        diputado3.setPartidoPolitico("PSOE");
        diputado3.setProvinciaQueRepresenta("Teruel");

        Senador senador = new Senador();
        senador.setNombre("Pedro Manuel Rollán Ojeda");
        senador.setDNI("30269645T");
        senador.setPartidoPolitico("PP");
        senador.setProvinciaQueRepresenta("No lo sé");


        listaLegisladores.add(diputado);
        listaLegisladores.add(diputado2);
        listaLegisladores.add(diputado3);

        listaLegisladores.add(senador);

        System.out.println(listaLegisladores);



    }
}
