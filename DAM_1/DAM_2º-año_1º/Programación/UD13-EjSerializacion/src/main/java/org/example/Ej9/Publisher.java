package org.example.Ej9;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.example.Ej5.Book;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Publisher {
    private String nombre;
    private String address;
    private List<Book> books;

    public Publisher() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @XmlElement(name = "book")
    @XmlJavaTypeAdapter(BookTitleAdapter.class)
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    @JsonGetter("books")
    public List<String> getBookTitles(){
        List<String> listaTitulos = new ArrayList<>();
        for (Book libro : books){
            String titulo = libro.getTitle();
            listaTitulos.add(titulo);

        }
        return listaTitulos;
    }
}
