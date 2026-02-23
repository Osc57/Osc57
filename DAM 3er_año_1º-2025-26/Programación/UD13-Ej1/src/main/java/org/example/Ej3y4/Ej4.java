package org.example.Ej3y4;

/*
4. Ejercicio 4: Tomar el JSON producido en el Ejercicio 3 y deserializarlo de nuevo a una
instancia de “Library” usando FasterXML.
*/

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Ej1y2.Book;

import java.io.File;
import java.io.IOException;

public class Ej4 {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Library library = objectMapper.readValue(new File("Librería.json"), Library.class);

            for (Book b : library.getListaLibros()) {
                System.out.println(b);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
