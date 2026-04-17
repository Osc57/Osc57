package org.example.Vista;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Vista.Login.*;

public class GestionEmpleado extends JFrame {

    public GestionEmpleado() {
        this.setTitle("Gestión Empleados");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //configurarCierreVentana(this);

        JPanel panelBotonesCentro = getjPanelBotonesCentro();
        JPanel panelBotonRetorno = getjPanelBotonRetorno();

        this.add(panelBotonesCentro, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);

    }

    private JPanel getjPanelBotonesCentro() {
        JPanel panelGestion = new JPanel(new GridLayout(3, 1, 15, 15));
        panelGestion.setBorder(BorderFactory.createEmptyBorder(50, 70, 20, 70));
        panelGestion.setBackground(COLOR_FONDO_GRIS_CLARO);

        JButton botonDarAlta = crearEstiloBoton("<html>Dar de alta <br> empleado</html>");
        botonDarAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DarAltaEmpleado().setVisible(true);

            }
        });

        JButton botonModificar = crearEstiloBoton("<html>Modificar datos <br> empleado</html>");
        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();

            }
        });

        JButton botonDarBaja = crearEstiloBoton("<html>Dar de baja <br> empleado</html>");
        botonDarBaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();

            }
        });

        panelGestion.add(botonDarAlta);
        panelGestion.add(botonModificar);
        panelGestion.add(botonDarBaja);

        return panelGestion;
    }

    private JButton crearEstiloBoton(String texto) {
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

    private JPanel getjPanelBotonRetorno() {
        JPanel panelBotonRetorno = new JPanel(new BorderLayout());
        JButton botonRetorno = new JButton("←");
        panelBotonRetorno.add(botonRetorno, BorderLayout.SOUTH);
        panelBotonRetorno.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 320));
        panelBotonRetorno.setBackground(COLOR_FONDO_GRIS_CLARO);

        botonRetorno.setFocusPainted(false);
        botonRetorno.setBackground(COLOR_BOTON_GRIS_CLARO);
        botonRetorno.setFont(FUENTE_EMOJI);

        botonRetorno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GestionAfterLogin().setVisible(true);
            }
        });
        return panelBotonRetorno;
    }

    public static void main(String[] args) {
        new GestionEmpleado().setVisible(true);
    }
}
