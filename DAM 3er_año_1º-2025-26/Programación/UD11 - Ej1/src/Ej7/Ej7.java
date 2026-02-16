package Ej7;

/*
7. Escribe un programa que permita crear dos listas de palabras y que, a
continuación, escriba las siguientes listas (en las que no debe haber repeticiones):
• Lista de palabras que aparecen en las dos listas.
• Lista de palabras que aparecen en la primera lista, pero no en la segunda.
• Lista de palabras que aparecen en la segunda lista, pero no en la primera.
• Lista de palabras que aparecen en alguna de las dos listas.
Ejemplo de listas:
var list1 = new List<string>() {"Ann", "Carol", "Mary", "Joe",
"John", "Kevin", "Jack", "Jack", "Lucy", "Laura", "George",
"Ann", "Johnny", "Charlie", "Hillary"};
var list2 = new List<string>() { "Ann", "Martha", "Noel",
"Mark", "Pamela", "Elisabeth", "Laura", "Jane", "Mildred",
"Laura", "Rue", "Ann", "Jacob", "Sidney", "Sophia", "Tyler" };
*/

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Ej7 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(List.of(
                "Ann", "Carol", "Mary", "Joe",
                "John", "Kevin", "Jack", "Jack", "Lucy", "Laura",
                "George", "Ann", "Johnny", "Charlie", "Hillary"
        ));

        List<String> list2 = new ArrayList<>(List.of(
                "Ann", "Martha", "Noel", "Mark", "Pamela",
                "Elisabeth", "Laura", "Jane", "Mildred", "Laura",
                "Rue", "Ann", "Jacob", "Sidney", "Sophia", "Tyler"
        ));

        Set<String> set1 = new HashSet<>(list1);
        Set<String> set2 = new HashSet<>(list2);

        Set<String> interseccion = new HashSet<>(set1);
        interseccion.retainAll(set2);
        System.out.println("En ambas listas: " + interseccion);

        Set<String> soloEnPrimera = new HashSet<>(set1);
        soloEnPrimera.removeAll(set2);
        System.out.println("Solo en la primera: " + soloEnPrimera);

        Set<String> soloEnSegunda = new HashSet<>(set2);
        soloEnSegunda.removeAll(set1);
        System.out.println("Solo en la segunda: " + soloEnSegunda);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("En alguna de las dos (todas): " + union);
    }
}


