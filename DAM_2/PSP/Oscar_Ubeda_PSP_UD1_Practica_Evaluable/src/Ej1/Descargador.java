package Ej1;

import java.util.Random;

public class Descargador implements Runnable {

    private String archivo;

    public Descargador(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void run() {
        Random r = new Random();
        int nRandom = r.nextInt(500, 1500);

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(nRandom);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static void main() {
        GestorDescargas gd = new GestorDescargas();

        Thread[] descargadores = new Thread[6];

        descargadores[0] = new Thread(new Descargador("Archivo-1.pdf"), "[Descargador-1]");
        descargadores[1] = new Thread(new Descargador("Archivo-2.pdf"), "[Descargador-2]");
        descargadores[2] = new Thread(new Descargador("Archivo-3.pdf"), "[Descargador-3]");
        descargadores[3] = new Thread(new Descargador("Archivo-4.pdf"), "[Descargador-4]");
        descargadores[4] = new Thread(new Descargador("Archivo-5.pdf"), "[Descargador-5]");
        descargadores[5] = new Thread(new Descargador("Archivo-6.pdf"), "[Descargador-6]");

        for (Thread d : descargadores) {
            d.start();
        }

        

    }


}
