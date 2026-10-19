package Ej2;

public class Principal {
    static void main() {

        ColaTareas colaCompartida = new ColaTareas();

        Thread hiloProductor = new Thread(new Productor(colaCompartida), "Productor");
        Thread hiloConsumidor1 = new Thread(new Consumidor(colaCompartida), "Consumidor-1");
        Thread hiloConsumidor2 = new Thread(new Consumidor(colaCompartida), "Consumidor-2");

        System.out.println("--- Iniciando sistema de procesamiento --- \n");
        hiloProductor.start();
        hiloConsumidor1.start();
        hiloConsumidor2.start();

        try {
            hiloProductor.join();
            hiloConsumidor1.join();
            hiloConsumidor2.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido inesperadamente.");
        }

        System.out.println("\n--- Proceso finalizado. Todas las tareas han sido procesadas sin bloqueos ---");
    }
}
