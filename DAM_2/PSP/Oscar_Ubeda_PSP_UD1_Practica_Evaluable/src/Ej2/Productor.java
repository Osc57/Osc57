package Ej2;

class Productor implements Runnable {
    private final ColaTareas cola;

    public Productor(ColaTareas cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                cola.producir(i);
                Thread.sleep(500);
            }

            cola.producir(-1);
            cola.producir(-1);

            System.out.println("[Productor] Ha finalizado la generación de tareas.");

        } catch (InterruptedException e) {
            System.out.println("[Productor] Interrumpido de forma inesperada.");
        }
    }
}
