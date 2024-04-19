package org.iesch.Ej_10;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.iesch.Ej_5.Book;
import org.iesch.Ej_7.Author;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LibraryCatalog libraryCatalog = new LibraryCatalog();

        Book book1 = new Book("Don Quijote","Cervantes",1605);
        Book book2 = new Book("Novelas Ejemplares","Cervantes",1616);

        Author author = new Author();
        author.setName("Cervantes");
        author.setBooksWritten(Arrays.asList(book1,book2));

        Map<Author, org.iesch.Ej_1y2.Book> catalogo = new HashMap<>();
        catalogo.put(author, book1);

        libraryCatalog.setCatalog(catalogo);

        //Serializamos a JSON

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(libraryCatalog);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
