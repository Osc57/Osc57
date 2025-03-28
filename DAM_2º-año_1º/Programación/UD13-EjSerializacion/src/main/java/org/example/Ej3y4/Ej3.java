package org.example.Ej3y4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Ej1y2.Book;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Crear una clase “Library” que contenga una lista de “Book”. Serializar una
 * instancia de “Library” a JSON usando FasterXML.
 **/

public class Ej3 {
    public static void main(String[] args) {
        Library library = new Library(new File("Librería.json"), Library.class);
        library.meterLibro(new Book("Veinte Mil Leguas de Viaje Submarino", "Julio Verne", 1870));
        library.meterLibro(new Book("Don Quijote de La Mancha", "Miguel de Cervantes", 1605));

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
