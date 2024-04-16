package org.iesch.Ej_6;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.iesch.Ej_1y2.Book;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement
public class Library {
    private List<Book> listaLibros;

    public Library() {

        this.listaLibros = new ArrayList<>();
    }
    public void meterLibro(Book book){

        this.listaLibros.add(book);
    }

    public List<Book> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Book> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.meterLibro(new Book("Las mil y una historias","Alberto Chicote",2001));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(library);
            System.out.println(json);

            objectMapper.writeValue(Paths.get("Librería.json").toFile(), library);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
