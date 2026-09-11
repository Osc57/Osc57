package org.example.Examen.Ej2;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.example.Examen.Ej1.Registro;

import java.io.*;
import java.util.ArrayList;

public class Ej2 {
    public static void main(String[] args) {
        ArrayList<Registro> listaRegistros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("DATA.csv"))) {
            String linea;
            br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] lista = linea.split(",");
                Registro registro = new Registro(lista);
                listaRegistros.add(registro);

            }

            ArrayList<Registro> franceses = new ArrayList<>();

            for (Registro r : listaRegistros) {
                if (r.getCountry().equalsIgnoreCase("FR")) {
                    franceses.add(r);
                }
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(ListaRegistros.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(new ListaRegistros(franceses), new File("Francia.xml"));


        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Error con el procesamiento del archivo: " + e.getMessage());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
