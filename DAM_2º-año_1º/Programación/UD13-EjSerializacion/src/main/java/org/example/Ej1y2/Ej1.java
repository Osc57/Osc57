package org.example.Ej1y2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Book;

import java.io.IOException;
import java.nio.file.Paths;

public class Ej1 {
    public static void main(String[] args) {
        Book book = new Book("Don Quijote de La Mancha", "Miguel de Cervantes", 1605);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(book);
            System.out.println(json);

            objectMapper.writeValue(Paths.get("Libro.json").toFile(), book);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
