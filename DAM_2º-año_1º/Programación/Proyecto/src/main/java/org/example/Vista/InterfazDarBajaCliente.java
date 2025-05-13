package org.example.Vista;

import javax.swing.*;
import java.awt.*;

import static org.example.Vista.InterfazDarAltaCliente.FUENTE_CAMPOS;

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



        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelGestionDni, BorderLayout.CENTER);
    }

    private JPanel getjPanelGestionDni(){
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        JPanel panelDNI = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton botonConfirmar = new JButton("Confirmar");

        txtDni = crearFields();

        panelDNI.add(txtDni);
        panelBoton.add(botonConfirmar);
        panelPrincipal.add(panelDNI, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;
    }

    private JTextField crearFields() {
        JTextField field = new JTextField(15);
        field.setFont(FUENTE_CAMPOS);
        field.setPreferredSize(new Dimension(150, 30));

        return field;
    }

    public static void main(String[] args) {
        new InterfazDarBajaCliente().setVisible(true);
    }
}
