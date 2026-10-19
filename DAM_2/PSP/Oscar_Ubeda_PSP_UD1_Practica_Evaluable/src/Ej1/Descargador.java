package Ej1;

import java.util.Random;

public class Descargador implements Runnable {
    private final String archivo;
    private final GestorDescargas gd;

    public Descargador(GestorDescargas gd, String archivo) {
        this.archivo = archivo;
        this.gd = gd;
    }

    @Override
    public void run() {
        Random r = new Random();
        int nRandom = r.nextInt(500, 1501);

        try {
            Thread.sleep(nRandom);
            gd.registrarDescarga(archivo);

        } catch (InterruptedException e) {
            System.out.println("[" + Thread.currentThread().getName() + "] La descarga de " + archivo + " ha sido interrumpida.");
            return;
        }
    }

    public static void main(String[] args) {
        GestorDescargas gd = new GestorDescargas();

        Thread[] descargadores = new Thread[6];
        String[] nombresArchivos = {
                "Archivo-1.pdf", "Archivo-2.pdf", "Archivo-3.pdf",
                "Archivo-4.pdf", "Archivo-5.pdf", "Archivo-6.pdf"
        };

        for (int i = 0; i < descargadores.length; i++) {
            Descargador tarea = new Descargador(gd, nombresArchivos[i]);
            descargadores[i] = new Thread(tarea, "Descargador-" + (i + 1));

            descargadores[i].start();
        }

        for (Thread t : descargadores) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("El hilo principal fue interrumpido.");
            }
        }

        System.out.println("\nTotal de descargas completadas con éxito: " + gd.getDescargasCompletadas());
    }


}
