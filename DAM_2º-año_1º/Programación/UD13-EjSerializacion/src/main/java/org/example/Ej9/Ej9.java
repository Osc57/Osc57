package org.example.Ej9;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Ej5.Book;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

public class Ej9 {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        publisher.setNombre("Pierre–Jules Hetzel");
        publisher.setAddress("Mónaco");

        Book book = new Book("Veinte Mil Leguas de Viaje Submarino","Julio Verne",1870);
        Book book1 = new Book("La Vuelta al Mundo en 80 días", "Julio Verne", 1873);

        publisher.setBooks(Arrays.asList(book,book1));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(publisher);
            System.out.println(json);
            objectMapper.writeValue(Paths.get("Publisher.json").toFile(), publisher);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        try {
            JAXBContext context = JAXBContext.newInstance(Publisher.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(publisher, new File("Publisher.xml"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
