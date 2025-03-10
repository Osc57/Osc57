package org.example.Ej1y2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Ej2 {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Book book = objectMapper.readValue(new File("Libro.json"), Book.class);
            System.out.println(book);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
