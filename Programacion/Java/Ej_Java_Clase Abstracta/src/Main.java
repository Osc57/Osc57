import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    static ArrayList<Legislador> listaLegisladores = new ArrayList<>();

    public static void main(String[] args) {


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

        CrearLegisladoresEnFichero(listaLegisladores);

    }

    public static void CrearLegisladoresEnFichero(ArrayList<Legislador> listaLegisladores) {
        File archivo = new File("ladrones.txt");

        try {
            FileWriter fileWriter = new FileWriter(archivo);

            for (Legislador legislador : listaLegisladores) {
                fileWriter.write(String.valueOf(legislador.getClass()).replace("class", "").trim() + ":" + "\n");
                fileWriter.write(legislador.getNombre() + "\n");
                fileWriter.write(legislador.getDNI() + "\n");
                fileWriter.write(legislador.getPartidoPolitico() + "\n");
                fileWriter.write(legislador.getProvinciaQueRepresenta()+ "\n");
                fileWriter.write("\n");

            }
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }


    }
}
