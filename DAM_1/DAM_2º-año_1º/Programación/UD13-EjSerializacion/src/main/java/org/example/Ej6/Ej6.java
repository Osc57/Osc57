package org.example.Ej6;

import org.example.Ej1y2.Book;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Repetir los Ejercicios 3 y 4, pero esta vez serializar a XML usando JAXB.
 **/

public class Ej6 {
    public static void main(String[] args) {
        Library library = new Library(new File("Librería.xml"), Library.class);
        library.meterLibro(new Book("Veinte Mil Leguas de Viaje Submarino", "Julio Verne", 1870));
        library.meterLibro(new Book("Don Quijote de La Mancha", "Miguel de Cervantes", 1605));

        try {
            JAXBContext context = JAXBContext.newInstance(Library.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(library, new File("Libreria.xml"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
