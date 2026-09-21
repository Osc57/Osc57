package Ejercicios_Steams.Ej1;

/*
Ejercicio 1:
Crea una clase Fruta con al menos dos atributos, nombre y color.
Crea una lista con diferentes frutas. Llámala frutería
Obtén una lista de Strings, que contenga el nombre de las frutas que contenía la frutería.
*/

import java.util.List;

public class Ej1 {
    static void main() {
        List<Fruta> fruteria = List.of(
                new Fruta("Banana", "Amarillo"),
                new Fruta("Plátano", "Amarillo"),
                new Fruta("Manzana", "Rojo"),
                new Fruta("Pera", "Verde"));

        List<String> nombresFrutas = fruteria.stream()
                .map(Fruta::getNombre).toList();


        nombresFrutas.forEach(System.out::println);
    }
}
