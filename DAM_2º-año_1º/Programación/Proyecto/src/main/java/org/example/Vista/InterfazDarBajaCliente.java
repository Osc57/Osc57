package org.example.Vista;

import javax.swing.*;
import java.awt.*;

public class InterfazDarBajaCliente extends JFrame{
    private static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 25);

    private JTextField txtDni = new JTextField();

    public InterfazDarBajaCliente(){
        this.setTitle("Dar de Baja");
        this.setSize(440, 420);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel introducirCliente = new JLabel("•Introduce el DNI del Cliente");
        introducirCliente.setFont(FUENTE_TITULO);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelGestionDni = getjPanelGestionDni();


        txtDni.setColumns(10);

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(txtDni, BorderLayout.CENTER);
    }

    private JPanel getjPanelGestionDni(){
        JPanel panelDNI = new JPanel();

        JButton botonConfirmar = new JButton("Confirmar");

        panelDNI.add(txtDni, BorderLayout.CENTER);
        panelDNI.add(botonConfirmar, BorderLayout.SOUTH);

        return panelDNI;
    }


    public static void main(String[] args) {
        new InterfazDarBajaCliente().setVisible(true);
    }
}
