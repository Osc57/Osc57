package Ej7;

import java.util.*;

/**
 * Escribe un programa que permita crear dos listas de palabras y que, a
 * continuación, escriba las siguientes listas (en las que no debe haber repeticiones):
 * • Lista de palabras que aparecen en las dos listas.
 * • Lista de palabras que aparecen en la primera lista, pero no en la segunda.
 * • Lista de palabras que aparecen en la segunda lista, pero no en la primera.
 * • Lista de palabras que aparecen en alguna de las dos listas.
 * Ejemplo de listas:
 * var list1 = new List<string>() {"Ann", "Carol", "Mary", "Joe",
 * "John", "Kevin", "Jack", "Jack", "Lucy", "Laura", "George",
 * "Ann", "Johnny", "Charlie", "Hillary"};
 * var list2 = new List<string>() { "Ann", "Martha", "Noel",
 * "Mark", "Pamela", "Elisabeth", "Laura", "Jane", "Mildred",
 * "Laura", "Rue", "Ann", "Jacob", "Sidney", "Sophia", "Tyler" };
 **/

public class Ej7 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Ann", "Carol", "Mary", "Joe", "John", "Kevin", "Jack", "Jack", "Lucy", "Laura", "George", "Ann", "Johnny", "Charlie", "Hillary");
        List<String> list2 = Arrays.asList("Ann", "Martha", "Noel", "Mark", "Pamela", "Elisabeth", "Laura", "Jane", "Mildred", "Laura", "Rue", "Ann", "Jacob", "Sidney", "Sophia", "Tyler");

        Set<String> list1NoDuplicad = new HashSet<>(list1);
        Set<String> list2NoDuplicad = new HashSet<>(list2);

        Set<String> listPalabrAmbasList = new HashSet<>(list1NoDuplicad);
        listPalabrAmbasList.retainAll(list2NoDuplicad);

        System.out.println("Las palabras que hay en ambas listas: " + listPalabrAmbasList);

        Set<String> palabrasList1 = new HashSet<>(list1NoDuplicad);
        list2NoDuplicad.forEach(palabrasList1::remove);
        System.out.println("Las palabras que solo aparecen en la primera lista pero no en la segunda: " + palabrasList1);

        Set<String> palabrasList2 = new HashSet<>(list2NoDuplicad);
        list1NoDuplicad.forEach(palabrasList1::remove);
        System.out.println("Las palabras que solo aparecen en la segunda lista pero no en la primera: " + palabrasList2);

        Set<String> palabrasAparecenDosList = new HashSet<>(list1NoDuplicad);
        palabrasAparecenDosList.addAll(list2NoDuplicad);
        System.out.println("Las palabras que aparecen en alguna de las dos listas: " + palabrasAparecenDosList);

    }
}
