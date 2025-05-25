package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Vista.InterfazLogin.*;
import static org.example.Vista.InterfazLogin.COLOR_BOTON_GRIS_CLARO;
import static org.example.Vista.InterfazLogin.COLOR_FONDO_GRIS_CLARO;
import static org.example.Vista.InterfazLogin.FUENTE_BOTON;
import static org.example.Vista.InterfazLogin.FUENTE_EMOJI;

public class InterfazModificarCliente extends JFrame {

    public InterfazModificarCliente() {
        this.setLayout(new BorderLayout());
        this.setTitle("Gestión");
        this.setSize(500, 360);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(COLOR_FONDO_GRIS_CLARO);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel titulo = new JLabel("Seleccione una opción");
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 23, 20, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(FUENTE_TITULO_2);

        JPanel panelBotonesGetion = getjPanlepanelBotonesGestion();
        JPanel panelBotonRetorno = getjPanelBotonRetorno();

        this.add(titulo, BorderLayout.NORTH);
        this.add(panelBotonesGetion, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getjPanelBotonRetorno() {
        JPanel panelBotonRetorno = new JPanel(new BorderLayout());
        JButton botonRetorno = new JButton("←");
        panelBotonRetorno.add(botonRetorno, BorderLayout.SOUTH);
        panelBotonRetorno.setBorder(BorderFactory.createEmptyBorder(0, 60, 20, 320));
        panelBotonRetorno.setBackground(COLOR_FONDO_GRIS_CLARO);

        botonRetorno.setFocusPainted(false);
        botonRetorno.setBackground(COLOR_BOTON_GRIS_CLARO);
        botonRetorno.setFont(FUENTE_EMOJI);

        botonRetorno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InterfazGestionaCliente().setVisible(true);
                dispose();
            }
        });
        return panelBotonRetorno;
    }

    private JPanel getjPanlepanelBotonesGestion() {
        JPanel panelBotonesGestion = new JPanel(new GridLayout(1, 3, 15, 15));
        panelBotonesGestion.setBorder(BorderFactory.createEmptyBorder(20, 60, 50, 60));
        panelBotonesGestion.setBackground(COLOR_FONDO_GRIS_CLARO);

        JButton botonEditar = crearEstiloBoton("<html>Editar <br> Cliente</html>");
        botonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InterfazGestionEditaCliente().setVisible(true);
            }
        });

        JButton botonAltaCliente = crearEstiloBoton("Dar Alta");
        botonAltaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InterfazDarAltaCliente().setVisible(true);
            }
        });

        JButton botonBajaCliente = crearEstiloBoton("Dar Baja");
        botonBajaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InterfazDarBajaCliente().setVisible(true);
            }
        });


        panelBotonesGestion.add(botonAltaCliente);
        panelBotonesGestion.add(botonEditar);
        panelBotonesGestion.add(botonBajaCliente);

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
        InterfazModificarCliente gestiona = new InterfazModificarCliente();
        gestiona.setVisible(true);
    }
}
