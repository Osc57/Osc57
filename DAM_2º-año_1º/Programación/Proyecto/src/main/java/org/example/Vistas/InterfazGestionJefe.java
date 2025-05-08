package org.example.Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfazGestionJefe extends JFrame {
    private static final Color COLOR_FONDO_BOTON = new Color(230, 230, 230);
    private static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 25);
    private static final Font FUENTE_BOTONES = new Font("Arial", Font.BOLD, 18);
    private static final Font FUENTE_EMOJI = new Font("Arial", Font.BOLD, 25);

    public InterfazGestionJefe() {
        this.setTitle("Administrador");
        this.setSize(500, 350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new InterfazLogin().setVisible(true);
            }
        });

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
                if (JOptionPane.showConfirmDialog(InterfazGestionJefe.this, "¿Seguro que quieres volver a atrás?", "Volver a atrás",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    new InterfazSeleccionJefe().setVisible(true);
                    dispose();
                }
            }
        });
        return panelBotonRetorno;
    }

    private JPanel getjPanelBotonesCentro() {
        JPanel panelBotonesCentro = new JPanel(new GridLayout(1, 2, 20, 0));
        panelBotonesCentro.setBorder(BorderFactory.createEmptyBorder(10, 0, 100, 60));

        JButton insertar = crearEstiloBoton("Dar de Alta");
        JButton eliminar =  crearEstiloBoton("Dar de Baja");

        panelBotonesCentro.add(insertar);
        panelBotonesCentro.add(eliminar);
        return panelBotonesCentro;
    }

    private JButton crearEstiloBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTONES);
        boton.setBackground(COLOR_FONDO_BOTON);
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
