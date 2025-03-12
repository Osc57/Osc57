package org.example.Ej10;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Ej5.Book;
import org.example.Ej7.Author;
import org.example.Ej9.Publisher;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Paths;

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

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(libraryCatalog);
            System.out.println(json);
            objectMapper.writeValue(Paths.get("LibrayCatalog.json").toFile(), libraryCatalog);
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
