/*
5. Ejercicio 5 — Lanzamiento de varios procesos
Crea un programa Java que lance tres procesos independientes utilizando
ProcessBuilder.
Cada proceso deberá ejecutar un comando diferente de Windows:
• Proceso 1: mostrar la configuración de red mediante ipconfig.
• Proceso 2: mostrar el nombre del equipo mediante hostname.
• Proceso 3: realizar un ping a www.google.es.
Cada proceso deberá guardar su resultado en un fichero diferente:
ipconfig.txt
hostname.txt
ping.txt
El programa deberá:
• Crear los tres objetos ProcessBuilder.
• Lanzar los tres procesos.
• Redirigir la salida de cada proceso a su correspondiente fichero.
• Esperar a que terminen los tres procesos utilizando waitFor().
• Mostrar por consola el código de finalización de cada uno.
• Controlar las excepciones que puedan producirse.
Ampliación: modifica el programa para que los tres procesos se lancen antes de
esperar a que termine cualquiera de ellos. De esta forma podrás observar que los
procesos pueden ejecutarse de forma concurrente.
*/

public class Ej5 {
    static void main() {

    }
}
