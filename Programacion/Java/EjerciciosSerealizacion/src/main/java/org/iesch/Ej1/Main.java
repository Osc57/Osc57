package org.iesch.Ej1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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




    }
}
