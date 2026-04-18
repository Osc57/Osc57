package org.example.Utils;

import org.example.Vista.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Componentes {
    public static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 42);
    public static final Font FUENTE_TITULO_2 = new Font("Arial", Font.BOLD, 25);

    public static final Color COLOR_FONDO_GRIS_CLARO = new Color(240, 240, 240);
    public static final Color COLOR_BOTON_GRIS_CLARO = new Color(230, 230, 230);

    public static final Color COLOR_BOTONES_AZUL = new Color(70, 130, 180);

    public static final Font FUENTE_LABEL = new Font("Arial", Font.BOLD, 18);
    public static final Font FUENTE_CAMPOS = new Font("Arial", Font.PLAIN, 16);
    public static final Font FUENTE_EMOJI = new Font("Arial", Font.BOLD, 25);

    public static final Font FUENTE_BOTON = new Font("Arial", Font.BOLD, 18);
    public static final Font FUENTE_BOTONES = new Font("Arial", Font.BOLD, 18);


    public static JButton crearEstiloBotonSubmit(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTONES);
        boton.setBackground(COLOR_BOTONES_AZUL);
        boton.setFocusPainted(false);
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 50, 10, 45)
        ));
        return boton;
    }

    public static JButton crearEstiloBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTON);
        boton.setBackground(COLOR_BOTON_GRIS_CLARO);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(-10, -10, -10, -20)
        ));
        return boton;
    }

    public static JPanel getPanelBotonRetorno(JFrame ventanaActual, JFrame ventanaDestino) {

        JPanel panelBotonRetorno = new JPanel(new BorderLayout());
        JButton botonRetorno = new JButton("←");

        panelBotonRetorno.add(botonRetorno, BorderLayout.SOUTH);
        panelBotonRetorno.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 320));
        panelBotonRetorno.setBackground(COLOR_FONDO_GRIS_CLARO);

        botonRetorno.setFocusPainted(false);
        botonRetorno.setBackground(COLOR_BOTON_GRIS_CLARO);
        botonRetorno.setFont(FUENTE_EMOJI);

        botonRetorno.addActionListener(e -> {
            ventanaActual.dispose();
            ventanaDestino.setVisible(true);
        });

        return panelBotonRetorno;
    }

    public static JTextField crearFields() {
        JTextField field = new JTextField(19);
        field.setFont(FUENTE_CAMPOS);
        field.setPreferredSize(new Dimension(150, 30));

        return field;
    }

    public static JLabel crearLabels(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(FUENTE_LABEL);
        label.setPreferredSize(new Dimension(120, 30));

        return label;
    }

    public static JRadioButton crearRadioButtonEstilizado(String texto, boolean seleccionado) {
        JRadioButton rb = new JRadioButton(texto, seleccionado);

        // Estética: Fuente, color y quitar el borde de foco
        rb.setFont(FUENTE_LABEL);
        rb.setFocusPainted(false);
        rb.setOpaque(false); // Para que tome el color del panel de fondo
        rb.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return rb;
    }

    public static void configurarCierreVentana(JFrame ventana) {
        ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(ventana, "¿Quiere cerrar sesión?", "Cerrar sesión",
                        JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    ventana.dispose();
                    new Login().setVisible(true);
                }
            }
        });
    }

}
