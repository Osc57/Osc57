package org.example.Interfaces;

import javax.swing.*;
import java.awt.*;

public class InterfazLogin1 extends JFrame{
    private String usuario = "Admin";
    private String password = "1234";
    private Font colorInsertar = new Font("Arial", Font.PLAIN, 35);
    private Font colortextoButton = new Font("Arial", Font.PLAIN, 18);

    public InterfazLogin1(){
        this.setLayout(new GridLayout(3,1));
        this.setTitle("Login");
        this.setSize(500, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel textoLabel = new JLabel("LOGIN ");
        textoLabel.setFont(colorInsertar);
        this.add(textoLabel);

    }

    public static void main(String[] args) {
        InterfazLogin1 login1 = new InterfazLogin1();
        login1.setVisible(true);
    }
}
