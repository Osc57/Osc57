package Ej2;

import java.util.HashSet;

public class Ej2_HashMap {
    public static void main(String[] args) {
        HashSet<Book> books = new HashSet<>();

        books.add(new Book(123,"Don Quijote","Cervantes"));
        books.add(new Book(1234,"Spiderman","Marvel"));
        books.add(new Book(123,"Spiderman","DC"));

        //Mostrar los libros: No se mostraran duplicados

        for (Book book : books){
            System.out.println(book);
        }
    }
}
