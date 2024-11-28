package Ej4;

import java.util.ArrayList;

public class DemoTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket("Teléfono", 1, 449.99, 1.21);
        Ticket ticket1 = new Ticket("Etiquetas NFC", 150, 0.45, 1.21);

        ArrayList<Ticket> ticketlista = new ArrayList<>();
        ticketlista.add(ticket);
        ticketlista.add(ticket1);

        CalcularTickets calcularTickets = new CalcularTickets(ticketlista);
        calcularTickets.mostrarTicket();
        System.out.println(calcularTickets.calcularTicketSinIva());
        System.out.println(calcularTickets.calcularTicketConIva());
    }
}
