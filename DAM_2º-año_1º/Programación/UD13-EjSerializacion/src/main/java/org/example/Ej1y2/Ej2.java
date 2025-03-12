package org.example.Ej1y2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Tomar el JSON producido en el Ejercicio 1 y deserializarlo de nuevo a una
 * instancia de “Book” usando FasterXML.
 **/

public class Ej2 {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Book book = objectMapper.readValue(new File("Libro.json"), Book.class);
            System.out.println(book);
            System.out.println("Nombre: " + book.getTitle());
            System.out.println("Autor: " + book.getAuthor());
            System.out.println("Año de Lanzamiento: " + book.getYearPublished());

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
