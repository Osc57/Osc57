package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static org.example.Vista.InterfazLogin.*;

public class InterfazGestionJefe extends JFrame {


    public InterfazGestionJefe() {
        this.setTitle("Administrador");
        this.setSize(500, 350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel titulo = new JLabel("Gestiona a los Trabajadores");
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 23, 20, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(FUENTE_TITULO_2);

        JPanel panelBotonesCentro = getjPanelBotonesCentro();
        JPanel panelBotonRetorno = getjPanelBotonRetorno();


        this.add(titulo, BorderLayout.NORTH);
        this.add(panelBotonesCentro, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.WEST);
    }

    private JPanel getjPanelBotonRetorno() {
        JPanel panelBotonRetorno = new JPanel(new BorderLayout());
        JButton botonRetorno = new JButton("←");
        panelBotonRetorno.add(botonRetorno, BorderLayout.SOUTH);
        panelBotonRetorno.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));

        botonRetorno.setFocusPainted(false);
        botonRetorno.setBackground(COLOR_FONDO_GRIS_CLARO);
        botonRetorno.setFont(FUENTE_EMOJI);

        botonRetorno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InterfazSeleccionJefe().setVisible(true);
                dispose();

            }
        });
        return panelBotonRetorno;
    }

    private JPanel getjPanelBotonesCentro() {
        JPanel panelBotonesCentro = new JPanel(new GridLayout(1, 2, 20, 0));
        panelBotonesCentro.setBorder(BorderFactory.createEmptyBorder(10, 0, 100, 60));

        JButton insertar = crearEstiloBoton("Dar de Alta");
        JButton eliminar = crearEstiloBoton("Dar de Baja");

        panelBotonesCentro.add(insertar);
        panelBotonesCentro.add(eliminar);
        return panelBotonesCentro;
    }

    private JButton crearEstiloBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTONES);
        boton.setBackground(COLOR_BOTON_GRIS_CLARO);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        return boton;
    }


    public static void main(String[] args) {
        InterfazGestionJefe interfazJefe = new InterfazGestionJefe();
        interfazJefe.setVisible(true);
    }
}
