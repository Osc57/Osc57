package org.example.Vista;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Vista.Login.*;

public class GestionAfterLogin extends JFrame {

    public GestionAfterLogin() {
        this.setTitle("Gestión Empresa");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //configurarCierreVentana(this);

        JPanel panelBotonesGetion = getjPanlepanelBotonesGestion();
        JPanel panelBotonRetorno = getjPanelBotonRetorno();

        this.add(panelBotonesGetion, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);

    }

    private JPanel getjPanlepanelBotonesGestion() {
        JPanel panelBotonesGestion = new JPanel(new GridLayout(3, 1, 15, 15));
        panelBotonesGestion.setBorder(BorderFactory.createEmptyBorder(50, 70, 20, 70));
        panelBotonesGestion.setBackground(COLOR_FONDO_GRIS_CLARO);

        JButton botonGestiona = crearEstiloBoton("<html>Gestiona <br> Proyectos</html>");
        botonGestiona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();

            }
        });

        JButton botonDarCitaCliente = crearEstiloBoton("<html>Gestiona <br> Empleados</html>");
        botonDarCitaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GestionEmpleado().setVisible(true);
            }
        });

        JButton botonHistorialCliente = crearEstiloBoton("<html>Gestiona <br> Departamentos</html>");
        botonHistorialCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();

            }
        });

        panelBotonesGestion.add(botonGestiona);
        panelBotonesGestion.add(botonDarCitaCliente);
        panelBotonesGestion.add(botonHistorialCliente);

        return panelBotonesGestion;
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
                new Login().setVisible(true);
            }
        });
        return panelBotonRetorno;
    }

    public static void main(String[] args) {
        GestionAfterLogin insertarEmpleado = new GestionAfterLogin();
        insertarEmpleado.setVisible(true);
    }
}
