/*
Ejercicio 1 — Hilos escritores y sincronización
Crea un programa Java que trabaje con 3 hilos.
El hilo principal deberá crear y lanzar dos hilos:
El primer hilo deberá escribir por consola la palabra "Hola" 10 veces,
esperando 1 segundo entre cada escritura.
El segundo hilo deberá escribir por consola la palabra "DAM" 10 veces,
esperando 1 segundo entre cada escritura.
El hilo principal deberá lanzar primero el hilo que escribe "Hola" y, después de
50 ms, lanzar el hilo que escribe "DAM".
Cada mensaje deberá aparecer acompañado del nombre del hilo que lo ha
generado.
Por ejemplo:
Hilo-Hola: Hola
Hilo-DAM: DAM
Hilo-Hola: Hola
Hilo-DAM: DAM
Una vez lanzados los dos hilos, el hilo principal deberá esperar a que ambos
finalicen utilizando join().
Después de 5 segundos desde el comienzo de la ejecución de los dos hilos,
el hilo principal deberá interrumpir ambos hilos.
Cuando un hilo reciba la interrupción deberá:
• Mostrar un mensaje indicando que ha sido interrumpido.
• Finalizar su ejecución.
Finalmente, el hilo principal deberá mostrar:
Programa finalizado
*/

public class Ej1 implements Runnable {
    private final String palabra;

    public Ej1(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {

                System.out.println(Thread.currentThread().getName() + ": " + palabra);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

            System.out.println(Thread.currentThread().getName() + ": Ha sido interrumpido.");
        }

    }

    static void main(String[] args) {
        Thread t1 = new Thread(new Ej1("Hola"), "Hilo-Hola");
        t1.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(new Ej1("DAM"), "Hilo-DAM");
        t2.start();

        Thread temporizador = new Thread(() -> {
            try {
                Thread.sleep(5000);
                t1.interrupt();
                t2.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        temporizador.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa finalizado");
    }

}
