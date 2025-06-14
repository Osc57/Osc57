package org.example.Vista;

import org.example.Modelo.Trabajador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.Controlador.ControladorTrabajador.cargarTrabajadores;
import static org.example.Controlador.ControladorTrabajador.eliminarTrabajador;
import static org.example.Vista.InterfazLogin.*;
import static org.example.Vista.InterfazLogin.COLOR_BOTONES_AZUL;

public class InterfazDarBajaTrabajador extends JFrame {

    protected static JList<Trabajador> LISTA_NOMBRES_TRABAJADORES;
    protected static DefaultListModel<Trabajador> MODEL_USUARIO_TRABAJADORES;

    public InterfazDarBajaTrabajador(){
        this.setTitle("Dar de Baja");
        this.setSize(480, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Seleccione trabajador o Filtre el DNI");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelGestionDni = getjPanelGestionDni();
        JPanel panelBotonRetorno = getjPanelBotonRetorno();

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelGestionDni, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getjPanelGestionDni() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        JPanel panelBoton = new JPanel(new GridLayout(1, 2, 10, 10));

        JButton botonConfirmar = crearEstiloBoton("Confirmar");
        botonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionTrabajador();
            }
        });

        JButton botonFiltrar = crearEstiloBoton("Filtrar DNI");
        botonFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InterfazFiltrarDNITrabajador().setVisible(true);
                dispose();
            }
        });

        MODEL_USUARIO_TRABAJADORES = new DefaultListModel<>();
        LISTA_NOMBRES_TRABAJADORES = new JList<>(MODEL_USUARIO_TRABAJADORES);

        LISTA_NOMBRES_TRABAJADORES.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        LISTA_NOMBRES_TRABAJADORES.setFont(new Font("Arial", Font.PLAIN, 18));
        LISTA_NOMBRES_TRABAJADORES.setFixedCellHeight(35);
        LISTA_NOMBRES_TRABAJADORES.setBackground(COLOR_FONDO_GRIS_CLARO);

        JScrollPane jScrollPane = new JScrollPane(LISTA_NOMBRES_TRABAJADORES);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 10));

        ArrayList<Trabajador> trabajadores = cargarTrabajadores();
        for (Trabajador t : trabajadores) {
            MODEL_USUARIO_TRABAJADORES.addElement(t);
        }
        //MIRAR AQUI

        panelBoton.add(botonFiltrar);
        panelBoton.add(botonConfirmar);

        panelPrincipal.add(jScrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;
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
                new InterfazGestionJefe().setVisible(true);
                dispose();
            }
        });
        return panelBotonRetorno;
    }

    private void seleccionTrabajador() {
        Trabajador trabajadorSeleccion = LISTA_NOMBRES_TRABAJADORES.getSelectedValue();
        if (trabajadorSeleccion != null) {
            if (JOptionPane.showConfirmDialog(InterfazDarBajaTrabajador.this, "¿Quieres eliminar este usuario?", "Eliminar",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                eliminarTrabajador(trabajadorSeleccion.getDni());
                JOptionPane.showMessageDialog(null, "Trabajador eliminado con exito");
                dispose();
                new InterfazGestionJefe().setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona a un trabajador");
        }

    }

    private JButton crearEstiloBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTONES);
        boton.setBackground(COLOR_BOTONES_AZUL);
        boton.setFocusPainted(false);
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        return boton;
    }
}

