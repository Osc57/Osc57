package Ej3;

public class Ej3 implements Runnable {
    private final Cuenta cuenta;
    private final boolean esIngreso;

    // Constructor para pasarle la cuenta compartida y el tipo de operación al hilo
    public Ej3(Cuenta cuenta, boolean esIngreso) {
        this.cuenta = cuenta;
        this.esIngreso = esIngreso;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (esIngreso) {
                cuenta.ingresarDinero(100.0);
            } else {
                cuenta.retirarDinero(100.0);
            }
        }
    }

    static void main(String[] args) {
        Cuenta cuentaCompartida = new Cuenta(1000.0);

        Thread[] hilos = new Thread[5];

        hilos[0] = new Thread(new Ej3(cuentaCompartida, true), "Ingresador-1");
        hilos[1] = new Thread(new Ej3(cuentaCompartida, true), "Ingresador-2");
        hilos[2] = new Thread(new Ej3(cuentaCompartida, true), "Ingresador-3");
        hilos[3] = new Thread(new Ej3(cuentaCompartida, false), "Retirador-1");
        hilos[4] = new Thread(new Ej3(cuentaCompartida, false), "Retirador-2");

        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }

        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n[main] --- TODOS LOS HILOS FINALIZADOS ---");
        System.out.println("[main] Saldo final real en la cuenta: " + cuentaCompartida.getSaldo() + " €");
    }
}
