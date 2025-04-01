package org.example.InterfacesDeFormularios.Ej1;

import javax.swing.*;

/**
 *  Usa JFrame para crear una ventana.
 *  Agrega un JLabel con el texto &quot;¡Hola, mundo!&quot;.
 **/

public class Ej1 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Hola mundo");
        jFrame.setSize(400, 200);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jFrame.add(new JLabel("Hola mundo"));

        jFrame.setVisible(true);
    }
}
