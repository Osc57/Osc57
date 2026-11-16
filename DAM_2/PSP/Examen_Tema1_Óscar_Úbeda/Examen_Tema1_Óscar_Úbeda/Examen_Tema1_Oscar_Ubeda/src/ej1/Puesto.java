package ej1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Puesto implements Runnable {
    private final String nombre;
    private final BlockingQueue<Coche> cola;
    private final Random random = new Random();

    public Puesto(String nombre, BlockingQueue<Coche> cola) {
        this.nombre = nombre;
        this.cola = cola;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Espera automáticamente hasta que haya un coche disponible
                Coche cocheActual = cola.take();
                System.out.println("[" + nombre + "] Empieza a lavar a " + cocheActual.getNombre());

                // Simula la duración del lavado
                Thread.sleep(random.nextInt(500, 1500));

                System.out.println("[" + nombre + "] Terminó con " + cocheActual.getNombre());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
