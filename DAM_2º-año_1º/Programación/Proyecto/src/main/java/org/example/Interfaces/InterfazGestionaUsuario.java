package org.example.Interfaces;

import javax.swing.*;
import java.awt.*;

public class InterfazGestionaUsuario extends JFrame {
    private static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 25);
    private static final Color COLOR_FONDO = new Color(240, 240, 240);
    private static final Color COLOR_BOTONES = new Color(230, 230, 230);
    private static final Font FUENTE_BOTONES = new Font("Arial", Font.BOLD, 16);
    private static final Font FUENTE_EMOJI = new Font("Arial", Font.BOLD, 25);

    public InterfazGestionaUsuario() {
        this.setLayout(new BorderLayout());
        this.setTitle("Gestión");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(COLOR_FONDO);
        this.setResizable(false);

        JLabel titulo = new JLabel("Gestiona a los Usuarios");
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 23, 20, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(FUENTE_TITULO);

        JPanel panelBotonesGetion = getjPanlepanelBotonesGestion();
        JPanel panelBotonRetorno = getjPanelBotonRetorno();

        this.add(titulo, BorderLayout.NORTH);
        this.add(panelBotonesGetion, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.WEST);
    }

    private JPanel getjPanelBotonRetorno() {
        JPanel panelBotonRetorno = new JPanel(new BorderLayout());
        JButton botonRetorno = new JButton("←");
        panelBotonRetorno.add(botonRetorno, BorderLayout.SOUTH);
        panelBotonRetorno.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));
        panelBotonRetorno.setBackground(COLOR_FONDO);

        botonRetorno.setFocusPainted(false);
        botonRetorno.setBackground(COLOR_BOTONES);
        botonRetorno.setFont(FUENTE_EMOJI);

        botonRetorno.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(InterfazGestionaUsuario.this, "¿Seguro que quieres volver?", "Volver a atrás",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                new InterfazSeleccionUsuario().setVisible(true);
                dispose();
            }
        });
        return panelBotonRetorno;
    }

    private JPanel getjPanlepanelBotonesGestion() {
        JPanel panelBotonesGestion = new JPanel(new GridLayout(2, 2, 15, 15));
        panelBotonesGestion.setBorder(BorderFactory.createEmptyBorder(10, 0, 100, 60));
        panelBotonesGestion.setBackground(COLOR_FONDO);

        JButton botonAltaCliente = crearBotonEstilizado("Alta");
        JButton botonBajaCliente = crearBotonEstilizado("Baja");
        JButton botonDarCiltaCliente = crearBotonEstilizado("Editar");
        JButton botonHistorialCliente = crearBotonEstilizado("Historial");

        panelBotonesGestion.add(botonAltaCliente);
        panelBotonesGestion.add(botonBajaCliente);
        panelBotonesGestion.add(botonDarCiltaCliente);
        panelBotonesGestion.add(botonHistorialCliente);

        return panelBotonesGestion;
    }

    private JButton crearBotonEstilizado(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTONES);
        boton.setBackground(COLOR_BOTONES);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        return boton;
    }


    public static void main(String[] args) {
        InterfazGestionaUsuario gestiona = new InterfazGestionaUsuario();
        gestiona.setVisible(true);
    }
}

