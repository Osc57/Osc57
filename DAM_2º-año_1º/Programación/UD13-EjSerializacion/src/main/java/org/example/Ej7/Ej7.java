package org.example.Ej7;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Ej5.Book;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

public class Ej7 {
    public static void main(String[] args) {
        Book book = new Book("Veinte Mil Leguas de Viaje Submarino","Julio Verne",1870);
        Book book1 = new Book("La Vuelta al Mundo en 80 días", "Julio Verne", 1873);

        Author author = new Author();
        author.setName("Julio Verne");
        author.setBooksWritten(Arrays.asList(book,book1));

        ObjectMapper objectMapper = new ObjectMapper();
        try{
            String json = objectMapper.writeValueAsString(author);
            System.out.println(json);
            objectMapper.writeValue(Paths.get("Autor.json").toFile(), author);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try{
            JAXBContext context = JAXBContext.newInstance(Author.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(author, new File("Autor.xml"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
