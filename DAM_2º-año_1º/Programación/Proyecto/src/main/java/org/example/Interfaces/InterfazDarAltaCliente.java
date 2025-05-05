package org.example.Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfazDarAltaCliente extends JFrame{
    private static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 25);

    public InterfazDarAltaCliente(){
        this.setTitle("Formulario");
        this.setSize(450, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new InterfazGestionaUsuario().setVisible(true);
            }
        });

        JLabel introducirCliente = new JLabel("•Introduce Los Datos Del Cliente");
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(20, 23, 20, 0));
        introducirCliente.setHorizontalAlignment(SwingConstants.LEFT);
        introducirCliente.setFont(FUENTE_TITULO);

        this.add(introducirCliente);
    }

    public static void main(String[] args) {
        new InterfazDarAltaCliente().setVisible(true);
    }
}
