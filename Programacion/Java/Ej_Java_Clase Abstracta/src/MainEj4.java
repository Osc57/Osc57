import Ej3.Diputado;
import Ej3.Legislador;
import Ej3.Senador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainEj4 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        List<Legislador> listaLadrones = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader("ladronesEj3.txt"));
            String linea = "";
            while ((linea = bufferedReader.readLine()) != null){
                if (linea.equals("Diputado:")){
                    String nombre = bufferedReader.readLine();
                    String DNI = bufferedReader.readLine();
                    String partidoPolitico = bufferedReader.readLine();
                    String provincia = bufferedReader.readLine();

                    Diputado diputado = new Diputado();
                    diputado.setNombre(nombre);
                    diputado.setDNI(DNI);
                    diputado.setPartidoPolitico(partidoPolitico);
                    diputado.setProvinciaQueRepresenta(provincia);

                    listaLadrones.add(diputado);

                } else if (linea.equals("Senador:")) {
                    String nombre = bufferedReader.readLine();
                    String DNI = bufferedReader.readLine();
                    String partidoPolitico = bufferedReader.readLine();
                    String provincia = bufferedReader.readLine();

                    Senador senador = new Senador();
                    senador.setNombre(nombre);
                    senador.setDNI(DNI);
                    senador.setPartidoPolitico(partidoPolitico);
                    senador.setProvinciaQueRepresenta(provincia);

                    listaLadrones.add(senador);

                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
