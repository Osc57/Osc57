package ej1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Lavadero {
    private static final BlockingQueue<Coche> colaCoches = new LinkedBlockingQueue<>();
    private static final Random random = new Random();

    public static void main(String[] args) {
        Thread[] coches = new Thread[random.nextInt(30, 100)];
        Thread[] puestos = new Thread[random.nextInt(2, 5)];

        System.out.println("Abriendo lavadero con " + puestos.length + " puestos y " + coches.length + " coches.\n");

        // 1. Creamos y arrancamos los puestos
        for (int i = 0; i < puestos.length; i++) {
            Puesto tareaPuesto = new Puesto("Puesto " + (i + 1), colaCoches);
            puestos[i] = new Thread(tareaPuesto);
            puestos[i].start();
        }

        // 2. Creamos y arrancamos los coches
        for (int i = 0; i < coches.length; i++) {
            Coche tareaCoche = new Coche("Coche " + (i + 1), colaCoches);
            coches[i] = new Thread(tareaCoche);
            coches[i].start();
        }
    }
}
