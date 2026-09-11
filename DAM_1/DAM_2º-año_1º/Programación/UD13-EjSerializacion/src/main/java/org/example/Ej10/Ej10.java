package org.example.Ej10;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Ej5.Book;
import org.example.Ej7.Author;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Crear una clase “LibraryCatalog” que contenga un mapa de “Author” a
 * “Book”. Asegurarse de que cuando se serializa una instancia de “LibraryCatalog”, el mapa se
 * serializa de manera que cada entrada en el mapa se convierte en un elemento con el nombre del
 * autor como la clave y el título del libro como el valor. Hacer esto tanto para JSON como para
 * XML.
 **/
public class Ej10 {
    public static void main(String[] args) {
        LibraryCatalog libraryCatalog = new LibraryCatalog();

        libraryCatalog.anadirLibro(new Author("Julio Verne"), new Book("Veinte Mil Leguas de Viaje Submarino", "Julio Verne", 1870));
        libraryCatalog.anadirLibro(new Author("Miguel de Cervantes"), new Book("Don Quijote de La Mancha", "Miguel de Cervantes", 1605));
        libraryCatalog.anadirLibro(new Author("Julio Verne"), new Book("La Vuelta al Mundo en 80 días", "Julio Verne", 1870));

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Map<String, String> map = new HashMap<>();
            for (Map.Entry<Author, Book> entry : libraryCatalog.getBookMap().entrySet()) {
                map.put(entry.getKey().getName(), entry.getValue().getTitle());
                objectMapper.writeValue(Paths.get("LibrayCatalog.json").toFile(), map);
                System.out.println(map);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            JAXBContext context = JAXBContext.newInstance(LibraryCatalog.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(libraryCatalog, new File("LibraryCatalog.xml"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
