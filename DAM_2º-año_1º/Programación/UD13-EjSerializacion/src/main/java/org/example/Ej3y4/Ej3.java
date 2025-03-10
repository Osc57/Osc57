package org.example.Ej3y4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Book;

import java.io.IOException;
import java.nio.file.Paths;

public class Ej3 {
    public static void main(String[] args) {
        Library library = new Library();
        library.meterLibro(new Book("Veinte Mil Leguas de Viaje Submarino","Julio Verne",1870));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(library);
            System.out.println(json);

            objectMapper.writeValue(Paths.get("Librería.json").toFile(), library);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
