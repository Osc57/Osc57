package org.example.Vista;

import javax.swing.*;

public class InsertarEmpleado extends JFrame {

    public InsertarEmpleado() {
        this.setTitle("Contratar Empleado");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public static void main(String[] args) {
        InsertarEmpleado insertarEmpleado = new InsertarEmpleado();
        insertarEmpleado.setVisible(true);
    }
}
