package org.example.Ej8;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Ej5.Book;
import org.example.Ej7.Author;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Crear una clase “Bookstore” que contenga una lista de “Book” y una lista de
 * “Author”. Serializar una instancia de “Bookstore” a JSON y a XML.
 **/

public class Ej8 {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();

        Book book = new Book("Veinte Mil Leguas de Viaje Submarino", "Julio Verne", 1870);
        Book book1 = new Book("La Vuelta al Mundo en 80 días", "Julio Verne", 1873);

        Author author = new Author();
        author.setName("Julio Verne");
        author.setBooksWritten(Arrays.asList(book, book1));

        bookstore.setAuthors(List.of(author));
        bookstore.setBooks(Arrays.asList(book, book1));

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(bookstore);
            System.out.println(json);
            objectMapper.writeValue(Paths.get("Bookstore.json").toFile(), bookstore);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            JAXBContext context = JAXBContext.newInstance(Bookstore.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bookstore, new File("Bookstore.xml"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}