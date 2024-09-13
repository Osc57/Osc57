package Ej5;

import Ej2.Book;

import java.util.TreeMap;

public class Ej5_TreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, Book> treeMap = new TreeMap<>();

        treeMap.put(1234, new Book(1234, "Don Quijote", "Cervantes"));
        treeMap.put(12, new Book(12, "Programando en Java", "Pepito Grillo"));
        treeMap.put(123, new Book(123, "Programando en Python", "Serpentín"));

        for (Integer isbn: treeMap.keySet()){
            System.out.println("Key: " + isbn + " Valor: " + treeMap.get(isbn));
        }

    }
}
