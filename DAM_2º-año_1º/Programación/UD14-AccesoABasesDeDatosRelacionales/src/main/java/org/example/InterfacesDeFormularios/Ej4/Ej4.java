package org.example.InterfacesDeFormularios.Ej4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ej4 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Hola mundo");
        jFrame.setLayout(new GridLayout(3,2));
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jPanel1 = new JPanel();
        JLabel user = new JLabel("Nombre: ");
        JTextField usuario = new JTextField(20);
        jPanel1.add(user);
        jPanel1.add(usuario);

        JPanel jPanel2 = new JPanel();
        JLabel passw = new JLabel("Email: ");
        JTextField contrasena = new JTextField(20);
        jPanel2.add(passw);
        jPanel2.add(contrasena);

        JButton jButton = new JButton("Registrar");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        jFrame.add(jPanel1);
        jFrame.add(jButton);
        jFrame.setVisible(true);
    }
}
