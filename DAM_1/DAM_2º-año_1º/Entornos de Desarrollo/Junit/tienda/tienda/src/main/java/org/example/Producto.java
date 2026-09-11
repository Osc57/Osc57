package org.example;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        if (precio < 0 || stock < 0) {
            throw new IllegalArgumentException("El precio y el stock no pueden ser negativos");
        }
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto() {
    }

    public Producto(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setPrecio(double precio) {
        if(precio>0){
            this.precio = precio;
        }else{
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }

    public void actualizarStock(int cantidad) {
        if (cantidad < 0 && Math.abs(cantidad) > stock) {
            throw new IllegalArgumentException("No hay suficiente stock disponible");
        }
        this.stock += cantidad;
    }
}
