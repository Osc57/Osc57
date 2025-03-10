package org.example.Ej5;

import org.example.Ej1y2.Book;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Ej5 {
    public static void main(String[] args) {
        Book book = new Book("La Vuelta al Mundo en 80", "Julio Verne", 1873);

        try {
            JAXBContext context = JAXBContext.newInstance(Book.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(book, new File("Libro.xml"));

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
