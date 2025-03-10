package org.example.Ej6;

import org.example.Ej1y2.Book;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement
public class Library {
    private List<Book> listaLibros;

    public Library() {
    }

    public Library(File file, Class<Library> libraryClass) {

        this.listaLibros = new ArrayList<>();
    }

    public void meterLibro(Book book) {

        this.listaLibros.add(book);
    }

    public List<Book> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Book> listaLibros) {
        this.listaLibros = listaLibros;
    }
}
