package Ej1;

public class GestorDescargas {
    private int descargasCompletadas;

    public GestorDescargas(int descargasCompletadas) {
        this.descargasCompletadas = descargasCompletadas;
    }

    public GestorDescargas() {
    }

    public int getDescargasCompletadas() {
        return descargasCompletadas;
    }

    public synchronized void registrarDescarga(String nombreArchivo) {
        descargasCompletadas++;
        System.out.println(Thread.currentThread().getName() + " " + nombreArchivo + " " + descargasCompletadas);
    }


}
