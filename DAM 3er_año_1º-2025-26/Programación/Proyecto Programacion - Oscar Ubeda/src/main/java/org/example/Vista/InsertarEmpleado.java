package org.example.Vista;

import javax.swing.*;

import static org.example.Vista.Login.configurarCierreVentana;

public class InsertarEmpleado extends JFrame {

    public InsertarEmpleado() {
        this.setTitle("Contratar Empleado");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        

    }

    public static void main(String[] args) {
        InsertarEmpleado insertarEmpleado = new InsertarEmpleado();
        insertarEmpleado.setVisible(true);
    }
}
