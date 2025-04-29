package org.example.Interfaces;

import javax.swing.*;
import java.awt.*;

public class InterfazJefe extends JFrame {
    private static final Color COLOR_FONDO_BOTON = new Color(230, 230, 230);
    private static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 18);
    private static final Font FUENTE_BOTONES = new Font("Arial", Font.PLAIN, 14);

    public InterfazJefe() {
        this.setTitle("Administrador");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        JLabel titulo = new JLabel("Gestiona a los Usuarios");
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(FUENTE_TITULO);

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 20, 0));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(40, 60, 50, 60));

        JButton insertar = new JButton("Dar de alta Trabajador");
        JButton eliminar = new JButton("Dar de baja Trabajador");

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
