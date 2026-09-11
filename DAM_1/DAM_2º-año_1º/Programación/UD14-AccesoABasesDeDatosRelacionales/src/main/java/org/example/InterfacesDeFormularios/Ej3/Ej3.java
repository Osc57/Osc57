package org.example.InterfacesDeFormularios.Ej3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ej3 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Hola mundo");
        jFrame.setLayout(new GridLayout(2,1));
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jPanel1 = new JPanel();
        JLabel user = new JLabel("Usuario: ");
        JTextField usuario = new JTextField(20);
        jPanel1.add(user);
        jPanel1.add(usuario);

        JButton jButton = new JButton("Botón");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame,"Hola " + usuario.getText());
            }
        });


        jFrame.add(jPanel1);
        jFrame.add(jButton);
        jFrame.setVisible(true);
    }
}
