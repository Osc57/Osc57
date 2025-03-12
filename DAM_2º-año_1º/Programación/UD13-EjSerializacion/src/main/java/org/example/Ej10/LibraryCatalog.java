package org.example.Ej10;

import org.example.Ej5.Book;
import org.example.Ej7.Author;

import java.util.HashMap;
import java.util.Map;

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
}
