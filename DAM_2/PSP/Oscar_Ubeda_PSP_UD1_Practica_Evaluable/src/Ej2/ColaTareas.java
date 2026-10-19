package Ej2;

import java.util.LinkedList;
import java.util.Queue;

public class ColaTareas {
    private final Queue<Integer> cola = new LinkedList<>();
    private final int CAPACIDAD_MAXIMA = 3;

    public synchronized void producir(int tarea) throws InterruptedException {
        while (cola.size() == CAPACIDAD_MAXIMA) {
            System.out.println("[Productor] Cola llena. Esperando espacio...");
            wait();
        }

        cola.add(tarea);

        if (tarea != -1) {
            System.out.println("[Productor] Tarea producida: " + tarea);
        }


        notifyAll();
    }

    public synchronized int consumir() throws InterruptedException {
        while (cola.isEmpty()) {
            String nombreHilo = Thread.currentThread().getName();
            System.out.println("[" + nombreHilo + "] Cola vacía. Esperando tareas...");
            wait();
        }

        int tarea = cola.poll();
        notifyAll();
        return tarea;
    }
}
