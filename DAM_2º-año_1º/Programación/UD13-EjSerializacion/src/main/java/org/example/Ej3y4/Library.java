package org.example.Ej3y4;

import org.example.Ej1y2.Book;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> listaLibros;

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
