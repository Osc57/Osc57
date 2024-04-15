package org.ieschEj_1y2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Las increíbles aventuras de Peter","Julian Margallo",1996);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(book);
            System.out.println(json);

            objectMapper.writeValue(Paths.get("Libro.json").toFile(), book);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Deserializar
        try {
            Book book1 = objectMapper.readValue(new File("Libro.json"), Book.class);
            System.out.println(book1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
