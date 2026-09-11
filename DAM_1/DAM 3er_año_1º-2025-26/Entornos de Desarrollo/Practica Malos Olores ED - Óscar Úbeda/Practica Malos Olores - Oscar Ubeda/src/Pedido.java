public class Pedido {
    public static void procesarPedido(String tipoCliente, double totalCompra) {
        // Inicializo estas varialbes aquí arriba para que el codigo quede más ordenado
        double descuento = 0.0;
        boolean clienteOk = true;

        // Lógica para sacar el porcentaje
        if (tipoCliente.equalsIgnoreCase("NORMAL")) {
            if (totalCompra > 100) {
                descuento = 0.05;
            }
            // Si compra menos de 100 no pongo else que se quede en 0.0 y ya
        } else if (tipoCliente.equalsIgnoreCase("VIP")) {
            if (totalCompra > 100) {
                descuento = 0.20;
            } else {
                descuento = 0.10; // Los VIP siepmre rascan algo
            }
        } else {
            clienteOk = false; // Por si escriben mal el tipo de cliente
        }

        // Si el cliente no existe corto aquí el programa y me ahorro posibles iteraciones
        if (!clienteOk) {
            System.out.println("Tipo de cliente desconocido");
            return;
        }

        // Cálculos y salida por pantalla
        double totalFinal = totalCompra - (totalCompra * descuento);

        if (descuento > 0) {
            // Multiplico por 100 para que quede bonito
            int porcentajeEntero = (int) (descuento * 100);
            System.out.println("Descuento " + porcentajeEntero + "%");
        } else {
            System.out.println("Sin descuento");
        }

        // Imprimimos el total solo una vez para no repetir codigo
        System.out.printf("Total: %.2f€", totalFinal); //Saco solo 2 decimales
        System.out.println();
    }

    public static void main(String[] args) {
        //Realizo distintas pruebas para saber si los procedimientos son los correctos

        //Cliente ViP con compra de mas de 100€
        procesarPedido("vip", 150.40);
        System.out.println("------------------------------------------------------");

        //Cliente VIP con compra menor a 100€
        procesarPedido("vip", 14.40);
        System.out.println("------------------------------------------------------");

        //Cliente NORMAL con compra mayor a 100€
        procesarPedido("normal", 150.40);
        System.out.println("------------------------------------------------------");

        //Cliente NORMAL con compre menor a 100€
        procesarPedido("normal", 15.40);
        System.out.println("------------------------------------------------------");

        //Cliente que no es tipo de clinete
        procesarPedido("avitual", 150.40);
    }

    /*DOCUMENTO DE MALOS OLORES
    1-Duplicación de código: El System.out.println del total cuatro veces.
    Si el día de mañana me piden cambiar el mensaje, voy a tener que buscar línea por línea y cambiarlo en todos lados,
    lo cual es poco eficiente.

    2-Anidamiento Excesivo: if dentro de otros if y el código se ha ido muy a la derecha.
    Es difícil de leer porque tengo que ir siguiendo demasiadas llaves para saber en qué parte de la lógica estoy.

    3-Mezcla de responsabilidades: Estoy haciendo el cálculo matemático y la salida por pantalla a la vez.
    Debería separar la lógica (sacar el descuento) de la presentación (imprimir el ticket) para que sea más limpio.

    4-Números mágicos: He metido los decimales como 0.05 o 0.20 directamente en las fórmulas. Si alguien lee esto,
    no sabe de dónde salen; es mejor guardarlos en una variable que explique que son porcentajes.

    5-Fragilidad ante nulos: He usado el equalsIgnoreCase partiendo de la variable tipoCliente.
    Si por lo que sea esa variable me llega vacía, mi programa va a pegar un petardazo y se va a cerrar.
     */
}



