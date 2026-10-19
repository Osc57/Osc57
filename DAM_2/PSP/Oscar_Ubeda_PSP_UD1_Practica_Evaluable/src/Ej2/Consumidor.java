package Ej2;

class Consumidor implements Runnable {
    private final ColaTareas cola;

    public Consumidor(ColaTareas cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        String nombreHilo = Thread.currentThread().getName();
        try {
            while (true) {
                int tarea = cola.consumir();

                if (tarea == -1) {
                    System.out.println("[" + nombreHilo + "] Señal de fin detectada. Finalizando...");
                    break;
                }

                System.out.println("[" + nombreHilo + "] Tarea procesada: " + tarea);
                
                Thread.sleep(800);
            }
        } catch (InterruptedException e) {
            System.out.println("[" + nombreHilo + "] Interrumpido durante el procesamiento.");
        }
    }
}