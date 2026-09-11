package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductoTest {
    private Producto producto;

    @BeforeEach
    public void p1(){
        producto = new Producto("Taladro", 13.5, 20);
    }
    

    @Test
    public void productoValido(){

       assertEquals("Taladro", producto.getNombre());
       assertEquals(13.5, producto.getPrecio());
       assertEquals(20, producto.getStock());
    }

    @Test
    public void acualizarStock(){
        producto.actualizarStock(40);
        assertEquals(60, producto.getStock());
    }

    @Test
    public void actualizarStockNegativo(){
        assertThrows(IllegalArgumentException.class, () -> {producto.actualizarStock(-15);});
    }

    @Test
    public void productoPrecioNegativo(){
        assertThrows(IllegalArgumentException.class, () -> {producto.setPrecio(-15.5);});
    }
}

