package org.example.Interfaces;

import javax.swing.*;
import java.awt.*;

public class InterfazJefe extends JFrame {
    private static final Color COLOR_FONDO_BOTON = new Color(230, 230, 230);
    private static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 25);
    private static final Font FUENTE_BOTONES = new Font("Arial", Font.BOLD, 18);

    public InterfazJefe() {
        this.setTitle("Administrador");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        JLabel titulo = new JLabel("Gestiona a los Trabajadores");
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(FUENTE_TITULO);

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 20, 0));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(30, 60, 60, 60));

        JButton insertar = new JButton("<html><center>Dar de Alta <br> Trabajador</center><html>");
        JButton eliminar = new JButton("<html><center>Dar de Baja <br> Trabajador</center><html>");

        insertar.setFocusPainted(false);
        eliminar.setFocusPainted(false);
        insertar.setFont(FUENTE_BOTONES);
        eliminar.setFont(FUENTE_BOTONES);
        insertar.setBackground(COLOR_FONDO_BOTON);
        eliminar.setBackground(COLOR_FONDO_BOTON);

        panelBotones.add(insertar);
        panelBotones.add(eliminar);

        this.add(titulo, BorderLayout.NORTH);
        this.add(panelBotones, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        InterfazJefe interfazJefe = new InterfazJefe();
        interfazJefe.setVisible(true);
    }
}
