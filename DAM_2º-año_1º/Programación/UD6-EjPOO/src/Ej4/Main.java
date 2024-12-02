package Ej4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Ticket> listaDeTickets = new ArrayList<>();

        int cont = 0;
        System.out.print("Cuantos objetos vas a comprar: ");
        int compra = scanner.nextInt();

        do {

            System.out.print("Que objeto quieres comprar: ");
            String objeto = scanner.next();

            System.out.print("Cuantas unidades quieres de ese objeto: ");
            int unidades = scanner.nextInt();

            System.out.print("Dime el precio de el objeto: ");
            double precio = scanner.nextDouble();

            System.out.print("Ahora dame el iva: ");
            double iva = scanner.nextDouble();

            System.out.println();
            Ticket ticket = new Ticket(objeto, unidades, precio, iva);

            listaDeTickets.add(ticket);

            compra--;
        } while (cont < compra);

        CalcularTickets calcularTickets = new CalcularTickets(listaDeTickets);

        System.out.print("Precio sin IVA: ");
        System.out.printf("%.2f%n",calcularTickets.calcularTicketSinIva());

        System.out.print("Precio con IVA: ");
        System.out.printf("%.2f%n",calcularTickets.calcularTicketConIva());


    }
}
