package ej1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Coche implements Runnable {
    private final String nombre;
    private final BlockingQueue<Coche> cola;
    private final Random random = new Random();

    public Coche(String nombre, BlockingQueue<Coche> cola) {
        this.nombre = nombre;
        this.cola = cola;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        try {
            // Simula que los coches no llegan todos al mismo segundo
            Thread.sleep(random.nextInt(100, 1500));
            System.out.println("-> " + nombre + " llega y entra en la cola.");
            cola.put(this); // Se mete a sí mismo en la cola
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
