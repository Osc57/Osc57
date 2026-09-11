package org.example.Ej10;

import org.example.Ej5.Book;
import org.example.Ej7.Author;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class LibraryCatalog {
    private Map<Author, Book> bookMap = new HashMap<>();

    public LibraryCatalog() {
    }

    public Map<Author, Book> getBookMap() {
        return bookMap;
    }

    public void setBookMap(Map<Author, Book> bookMap) {
        this.bookMap = bookMap;
    }

    public void anadirLibro(Author author, Book book){
        bookMap.put(author,book);
    }
}
