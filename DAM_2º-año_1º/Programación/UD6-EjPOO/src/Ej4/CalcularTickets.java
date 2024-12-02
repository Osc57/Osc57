package Ej4;

import java.util.ArrayList;

public class CalcularTickets {
    private ArrayList<Ticket> listaTickets;

    public CalcularTickets(ArrayList<Ticket> listaTickets) {
        this.listaTickets = listaTickets;
    }

    public ArrayList<Ticket> getListaTickets() {
        return listaTickets;
    }

    public void mostrarTicket() {
        for (Ticket ticket : listaTickets) {
            System.out.println(ticket);
        }
    }

    public double calcularTicketSinIva() {
        double dinero = 0;
        for (Ticket ticket : listaTickets) {
            dinero = dinero + ticket.calcularValorLinea();
        }
        return dinero;
    }
    public double calcularIVA(){
        double iva = 0;
        for (Ticket ticket : listaTickets){
            iva = iva + ticket.getIva();
        }
        return iva;
    }
    public double calcularTicketConIva() {
        double dineroIva = 0;
        for (Ticket ticket : listaTickets) {
            dineroIva = (dineroIva + ticket.calcularValorLinea()) * ticket.getIva();
        }
        return dineroIva;
    }
}
