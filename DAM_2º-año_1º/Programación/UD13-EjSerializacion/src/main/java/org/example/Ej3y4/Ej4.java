package org.example.Ej3y4;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Ej1y2.Book;

import java.io.File;
import java.io.IOException;

public class Ej4 {
    public static void main(String[] args) {
        Library library = new Library();
        library.meterLibro(new Book("Veinte Mil Leguas de Viaje Submarino", "Julio Verne", 1870));
        library.meterLibro(new Book("Don Quijote de La Mancha", "Miguel de Cervantes", 1605));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            for (Book b : library.getListaLibros()){
                b = objectMapper.readValue(new File("Librería.json"), Book.class);
                System.out.println(b);
            }
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
