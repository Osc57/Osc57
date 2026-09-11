package org.example.Ej1;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;

public class Ej1_xml {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();

        Persona persona1 = new Persona("Persona", 23, "Casa");
        Persona persona2 = new Persona("Persona2", 17, "Casa");
        Persona persona3 = new Persona("Persona4", 43, "Casa");

        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);


        try {
            JAXBContext context = JAXBContext.newInstance(ListaPersonas.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            ListaPersonas listaPersonas = new ListaPersonas(personas);

            marshaller.marshal(listaPersonas, new File("personas.xml"));

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }


    }
}
