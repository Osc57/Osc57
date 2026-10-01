/*
3. Crea un programa que trabaje con hilos. El hilo principal deberá lanzar 2 hilos,
el primero escribirá por consola 15 veces “Hola “ cada 2 segundos. El segundo
hilo escribirá “ mundo!” y el retorno de carro otras 15 veces también cada 2
segundos. Si el hilo principal lanza el segundo con un pequeño retraso (unos
20ms) el texto se mostrará por consola sin percatarnos que lo están
escribiendo 2 hilos diferentes. Modifica el programa de manera que el hilo
principal interrumpa al primer hilo transcurridos 5s desde el arranque de los
dos hilos. La respuesta ante la interrupción debe consistir en la salida y
finalización de la ejecución del hilo interrumpido.
*/

public class Ej3 implements Runnable {
    private String texto;

    public Ej3(String texto) {
        this.texto = texto;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 15; i++) {
                if (texto.equals("Hola ")) {
                    System.out.print(texto);
                } else {
                    System.out.println(texto);
                }


                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {

            System.out.println("\n[INFO] El hilo que escribía '" + texto.trim() + "' ha sido interrumpido y ha finalizado.");
        }
    }

    static void main(String[] args) {

        Ej3 tarea1 = new Ej3("Hola ");
        Ej3 tarea2 = new Ej3(" mundo!");


        Thread hilo1 = new Thread(tarea1);
        Thread hilo2 = new Thread(tarea2);


        hilo1.start();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hilo2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hilo1.interrupt();
    }
}
