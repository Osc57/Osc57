package Ej4;

import java.util.ArrayList;

public class Ticket {
    private String nombreArticulo;
    private int unidades;
    private double precio;
    private double iva;

    public Ticket(String nombreArticulo, int unidades, double precio, double iva) {
        this.nombreArticulo = nombreArticulo;
        this.unidades = unidades;
        this.precio = precio;
        this.iva = iva;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "Artículo: " + nombreArticulo + ", Unidades: " + unidades + ", Precio: " + precio + ", Iva: " + iva + '}';
    }

    public double calcularValorLinea() {
        return unidades * precio;
    }

}
