package org.example.Vista;

import javax.swing.*;
import java.awt.*;

import static org.example.Vista.InterfazLogin.*;

public class InterfazDarBajaCliente extends JFrame{

    private JTextField txtDni = new JTextField();

    public InterfazDarBajaCliente(){
        this.setTitle("Dar de Baja");
        this.setSize(440, 420);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel introducirCliente = new JLabel("•Introduce el DNI del Cliente");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelGestionDni = getjPanelGestionDni();



        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelGestionDni, BorderLayout.CENTER);
    }

    private JPanel getjPanelGestionDni(){
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        JPanel panelDNI = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton botonConfirmar = crearEstiloBoton("Confirmar");

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

    private JButton crearEstiloBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTONES);
        boton.setBackground(COLOR_BOTON_GRIS_CLARO);
        boton.setFocusPainted(false);
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        return boton;
    }

    public static void main(String[] args) {
        new InterfazDarBajaCliente().setVisible(true);
    }
}
