package ej1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Lavadero implements Runnable {
    static private final Queue<Thread> colaCoches = new LinkedList<>();

    static private final Random random = new Random();

    @Override
    public void run() {
        for (Thread coche : colaCoches) {
            //System.out.println(coche.getName());
        }
    }

    static void main() {
        Thread[] coches = new Thread[random.nextInt(30, 100)];

        Thread[] puestos = new Thread[random.nextInt(1, 5)];

        for (int i = 0; i < coches.length; i++) {
            Thread coche = new Thread(String.valueOf((new Coche("Coche" + (i + 1)))));
            coches[i] = coche;
        }

        for (int i = 0; i < puestos.length; i++) {
            Thread puesto = new Thread("Puesto " + (i + 1));
            puestos[i] = puesto;
        }

        for (Thread coche : coches) {
            coche.start();

            //colaCoches.add(coche);
            //System.out.println(coche.getName());
        }

        //System.out.println(colaCoches);
        for (Thread puesto : puestos) {
            puesto.start();
        }

    }
}
