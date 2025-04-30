package org.example.Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGestionJefe extends JFrame {
    private static final Color COLOR_FONDO_BOTON = new Color(230, 230, 230);
    private static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 25);
    private static final Font FUENTE_BOTONES = new Font("Arial", Font.BOLD, 18);
    private static final Font FUENTE_EMOJI = new Font("Arial", Font.BOLD, 25);

    public InterfazGestionJefe() {
        this.setTitle("Administrador");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        JLabel titulo = new JLabel("Gestiona a los Trabajadores");
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 23, 20, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(FUENTE_TITULO);

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
        botonRetorno.setBackground(COLOR_FONDO_BOTON);
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

    private static JPanel getjPanelBotonesCentro() {
        JPanel panelBotonesCentro = new JPanel(new GridLayout(1, 2, 20, 0));
        panelBotonesCentro.setBorder(BorderFactory.createEmptyBorder(20, 0, 70, 60));

        JButton insertar = new JButton("<html><center>Dar de Alta<br>Trabajador</center></html>");
        JButton eliminar = new JButton("<html><center>Dar de Baja<br>Trabajador</center></html>");

        insertar.setFocusPainted(false);
        eliminar.setFocusPainted(false);
        insertar.setFont(FUENTE_BOTONES);
        eliminar.setFont(FUENTE_BOTONES);
        insertar.setBackground(COLOR_FONDO_BOTON);
        eliminar.setBackground(COLOR_FONDO_BOTON);

        panelBotonesCentro.add(insertar);
        panelBotonesCentro.add(eliminar);
        return panelBotonesCentro;
    }


    public static void main(String[] args) {
        InterfazGestionJefe interfazJefe = new InterfazGestionJefe();
        interfazJefe.setVisible(true);
    }
}
