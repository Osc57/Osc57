package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Vista.InterfazLogin.*;

public class InterfazGestionaCliente extends JFrame {


    public InterfazGestionaCliente() {
        this.setLayout(new BorderLayout());
        this.setTitle("Gestión");
        this.setSize(500, 360);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(COLOR_FONDO_GRIS_CLARO);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel titulo = new JLabel("Gestiona a los Clientes");
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 23, 20, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(FUENTE_TITULO_2);

        JPanel panelBotonesGetion = getjPanlepanelBotonesGestion();

        this.add(titulo, BorderLayout.NORTH);
        this.add(panelBotonesGetion, BorderLayout.CENTER);

    }

    private JPanel getjPanlepanelBotonesGestion() {
        JPanel panelBotonesGestion = new JPanel(new GridLayout(1, 3, 15, 15));
        panelBotonesGestion.setBorder(BorderFactory.createEmptyBorder(20, 60, 90, 60));
        panelBotonesGestion.setBackground(COLOR_FONDO_GRIS_CLARO);

        JButton botonGestiona = crearEstiloBoton("<html>Gestiona <br> Cliente</html>");
        botonGestiona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InterfazModificarCliente().setVisible(true);//interfazModificarCliente tiene dar alta, baja y editar al cliente
            }
        });

        JButton botonDarCitaCliente = crearEstiloBoton("<html>Gestiona <br> Cita</html>");
        botonDarCitaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InterfazGestionCita().setVisible(true);//dar Cita, modificar Cita, eliminar Cita
            }
        });

        JButton botonHistorialCliente = crearEstiloBoton("<html>Mostrar <br> Historial</html>");
        botonHistorialCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InterfazSeleccionHistorial().setVisible(true);
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
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        return boton;
    }

    public static void main(String[] args) {
        new InterfazGestionaCliente().setVisible(true);
    }
}

