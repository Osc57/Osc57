package Ej6;

/*
6. Escribe un programa que crear una lista de 30 números aleatorios entre 0 y 99. A
continuación, el programa mostrará todos los números, pero sin elementos
repetidos en caso de que los hubiera.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.*;

import java.util.*;

public class Ej6 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            lista.add(random.nextInt(100));
        }

        Set<Integer> sinRepetidos = new HashSet<>(lista);
        Set<Integer> ordenadosSinRepetidos = new TreeSet<>(lista);

        System.out.println("Números únicos: " + sinRepetidos);
        System.out.println("Números únicos y ordenados: " + ordenadosSinRepetidos);
    }
}


