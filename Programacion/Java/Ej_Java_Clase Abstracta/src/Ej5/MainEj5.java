package Ej5;

import Ej5.modelos.Diputado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainEj5 {
    public static void main(String[] args) {
        List<Diputado> listaDiputados = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("congreso.csv"));
            String linea = "";

            while ((linea = bufferedReader.readLine()) != null){
                linea = linea.replace(";;", "; ;");
                String[] partes = linea.split(";");
                String nombre = partes[0];
                String grupo = partes[1];
                String lista = partes[2];
                String provincia = partes[3];
                String fechaAlta = partes[4];
                String fechaBaja = partes[5];

                if (fechaBaja.equals(" ")) fechaBaja = null;

                Diputado diputado = new Diputado(nombre,grupo,lista,provincia,fechaAlta,fechaBaja);

                listaDiputados.add(diputado);


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //Crear la interfaz
        System.out.println(listaDiputados);
    }
}
