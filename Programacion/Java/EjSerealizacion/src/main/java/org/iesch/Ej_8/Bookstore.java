package org.iesch.Ej_8;

import org.iesch.Ej_5.Book;
import org.iesch.Ej_7.Author;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
public class Bookstore {

    private List<Book> books;
    private List<Author> authors;

    public Bookstore() {
    }
    @XmlElement(name = "book")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    @XmlElement(name = "author")
    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
