package org.example.Vista;

import javax.swing.*;

import static org.example.Vista.Login.configurarCierreVentana;

public class GestionEmpleado extends JFrame {

    public GestionEmpleado() {
        this.setTitle("Gestión Empleados");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //configurarCierreVentana(this);
    }

    public static void main(String[] args) {
        new GestionEmpleado().setVisible(true);
    }
}
