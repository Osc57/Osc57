package Ap3.Ej3;

/*
Ej3. Dada una lista de estudiantes (donde cada estudiante es un objeto con
propiedades como nombre, edad, grado, etc.), escribir una función que devuelva
un Map donde las claves son los nombres de los estudiantes y los valores son los
objetos de los estudiantes.
*/

import java.util.*;

public class Ej3 {
    static void main() {
        List<Estudiante> estudianteList = List.of(
                new Estudiante("Manuel", 22, "Ciencias"),
                new Estudiante("Alonso", 21, "ADE"),
                new Estudiante("Maria", 23, "Abogadia"));


        System.out.print(mapEstudianteNombre(estudianteList));

    }

    static Map<String, Estudiante> mapEstudianteNombre(List<Estudiante> list) {
        Map<String, Estudiante> stringEstudianteMap = new HashMap<>();

        for (Estudiante e : list) {
            stringEstudianteMap.put(e.getNombre(), e);
        }

        return stringEstudianteMap;
    }
}
