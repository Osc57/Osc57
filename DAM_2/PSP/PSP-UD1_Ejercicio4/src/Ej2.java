/*
Ejercicio 2 — Hilo principal esperando a un hilo secundario
Crea una aplicación Java formada por un hilo principal y un hilo secundario.
El hilo secundario deberá mostrar los siguientes mensajes:
Inicio del programa
Procesos
Servicios
Multihilo
Sincronización
Fin del programa

Entre cada mensaje deberá esperar 3 segundos.
El hilo principal deberá lanzar el hilo secundario y quedarse esperando su
finalización.
Mientras está esperando, el hilo principal deberá mostrar cada segundo:
Hilo principal esperando...
El hilo principal podrá esperar como máximo el número de segundos indicado
mediante un parámetro recibido por main.
Por ejemplo:
java Ejercicio2 7
En este caso, el hilo principal esperará como máximo 7 segundos.
Si el hilo secundario todavía no ha terminado después de ese tiempo, el hilo
principal deberá:
• Interrumpir al hilo secundario.
• El hilo secundario deberá detectar la interrupción.
• Mostrar los mensajes que todavía no haya mostrado sin realizar
esperas entre ellos.
• Finalizar.
• El hilo principal deberá esperar finalmente a que termine el hilo
secundario.
• Mostrar el tiempo total de ejecución del programa.
Todos los mensajes deberán indicar qué hilo los está mostrando.
Por ejemplo:
[main] Hilo principal esperando...
[Hilo-Secundario] Procesos
[main] Hilo principal esperando...
*/

public class Ej2 implements Runnable {

    @Override
    public void run() {
        String[] importantInfo = {"Inicio del Programa", "Procesos", "Servicios", "Multi-Hilo", "Sincronización"};

        for (int i = 0; i < importantInfo.length; i++) {
            System.out.println(Thread.currentThread().getName() + " " + importantInfo[i]);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static void main(String[] args) {
        int segundosMaximos = 7;

        if (args.length > 0) {
            segundosMaximos = Integer.parseInt(args[0]);
        } else {
            System.out.println("[main] No se detectó parámetro. Usando valor por defecto: 7 segundos.");
        }

        long tiempoInicio = System.currentTimeMillis();


        Thread t2 = new Thread(new Ej2(), "[Hilo-Secundario]");
        t2.start();

        int segundosEsperados = 0;
        while (t2.isAlive() && segundosEsperados < segundosMaximos) {
            try {
                Thread.sleep(1000);
                segundosEsperados++;
                System.out.println("[main] Hilo principal esperando...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (t2.isAlive()) {
            t2.interrupt();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fin del Programa");
        long tiempoTotal = System.currentTimeMillis() - tiempoInicio;
        System.out.println("[main] Tiempo total de ejecución: " + (tiempoTotal / 1000.0) + " segundos.");
    }
}
