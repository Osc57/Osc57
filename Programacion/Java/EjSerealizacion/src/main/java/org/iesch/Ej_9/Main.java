package org.iesch.Ej_9;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.iesch.Ej_5.Book;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        publisher.setNombre("Planeta");
        publisher.setAddress("Plaza San Juan");

        Book book1 = new Book("Don Quijote","Cervantes",1605);
        Book book2 = new Book("Novelas Ejemplares","Cervantes",1616);

        publisher.setBooks(Arrays.asList(book1,book2));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(publisher);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
