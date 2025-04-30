package org.example.Interfaces;

import javax.swing.*;
import java.awt.*;

public class InterfazGestiona extends JFrame {

    public InterfazGestiona(){
        this.setLayout(new GridLayout(3, 1));
        this.setTitle("Gestión");
        this.setSize(500, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {
        InterfazGestiona gestiona = new InterfazGestiona();
        gestiona.setVisible(true);
    }
}
