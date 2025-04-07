package org.example.InterfacesDeFormularios.Ej5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Ej5 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Hola mundo");
        jFrame.setLayout(new GridLayout(3,1));
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DefaultTableModel modelo = new DefaultTableModel();
        JTable jt = new JTable(modelo);

        jFrame.add(jt);
        jFrame.setVisible(true);
    }
}
