package org.iesch.Ej_8;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.iesch.Ej_5.Book;
import org.iesch.Ej_7.Author;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();

        Book book1 = new Book("Don Quijote","Cervantes",1605);
        Book book2 = new Book("Novelas Ejemplares","Cervantes",1616);

        Author author = new Author();
        author.setName("Cervantes");
        author.setBooksWritten(Arrays.asList(book1,book2));

        bookstore.setAuthors(Arrays.asList(author));
        bookstore.setBooks(Arrays.asList(book1,book2));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(bookstore);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            JAXBContext context = JAXBContext.newInstance(Bookstore.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bookstore, System.out);
        } catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }



    }
}
