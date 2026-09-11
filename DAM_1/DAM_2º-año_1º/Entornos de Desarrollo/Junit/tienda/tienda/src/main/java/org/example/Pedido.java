package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Producto> productos;

    public Pedido() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        productos.add(producto);
    }

    public int obtenerCantidadProductos() {
        return productos.size();
    }

    public void eliminarProducto(String nombreProducto) {
        productos.removeIf(producto -> producto.getNombre().equalsIgnoreCase(nombreProducto));
    }

    public Producto buscarProducto(String nombreProducto) {
        return productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombreProducto))
                .findFirst()
                .orElse(null);
    }
}
