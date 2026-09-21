package Ejercicios_Streams.Ej1_Ej2;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
Ejercicio 2:
Utiliza la misma estructura del ejercicio 1, y ahora imprime por pantalla los colores de las
diferentes frutas. (No pueden aparecer colores repetidos.)
*/

public class Ej2 {
    static void main() {
        List<Fruta> fruteria = List.of(
                new Fruta("Banana", "Amarillo"),
                new Fruta("Plátano", "Amarillo"),
                new Fruta("Manzana", "Rojo"),
                new Fruta("Pera", "Verde"));

        Set<String> coloresFrutas = fruteria.stream()
                .map(Fruta::getColor).collect(Collectors.toSet());

        coloresFrutas.forEach(System.out::println);
    }
}
