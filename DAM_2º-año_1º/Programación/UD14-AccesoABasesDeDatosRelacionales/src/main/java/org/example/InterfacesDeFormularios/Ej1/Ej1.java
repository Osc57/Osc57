package org.example.InterfacesDeFormularios.Ej1;

import javax.swing.*;

public class Ej1 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Hola mundo");
        jFrame.setSize(400,200);

        jFrame.add(new JLabel("Hola mundo"));

        jFrame.setVisible(true);
    }
}
