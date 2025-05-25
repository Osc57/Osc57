package org.example.Vista;

import org.example.Modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.Controlador.ControladorCliente.cargarClientes;
import static org.example.Vista.InterfazDarBajaCliente.LISTA_NOMBRES_CLIENTES;
import static org.example.Vista.InterfazDarBajaCliente.MODEL_USUARIO_CLIENTES;
import static org.example.Vista.InterfazLogin.*;
import static org.example.Vista.InterfazLogin.COLOR_BOTONES_AZUL;

public class InterfazGestionEditaCliente extends JFrame {

    private static Cliente clienteSeleccion = new Cliente();

    public InterfazGestionEditaCliente() {
        this.setTitle("Editar");
        this.setSize(460, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Seleccione cliente o Filtre el DNI");
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
                obtenerDNICliente();
                seleccionCliente();

            }
        });

        MODEL_USUARIO_CLIENTES = new DefaultListModel<>();
        LISTA_NOMBRES_CLIENTES = new JList<>(MODEL_USUARIO_CLIENTES);

        LISTA_NOMBRES_CLIENTES.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        LISTA_NOMBRES_CLIENTES.setFont(new Font("Arial", Font.PLAIN, 18));
        LISTA_NOMBRES_CLIENTES.setFixedCellHeight(35);
        LISTA_NOMBRES_CLIENTES.setBackground(COLOR_FONDO_GRIS_CLARO);

        JScrollPane jScrollPane = new JScrollPane(LISTA_NOMBRES_CLIENTES);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 10));

        ArrayList<Cliente> clientes = cargarClientes();
        for (Cliente c : clientes) {
            MODEL_USUARIO_CLIENTES.addElement(c);
        }

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
                dispose();
                new InterfazModificarCliente().setVisible(true);
            }
        });
        return panelBotonRetorno;
    }

    private void seleccionCliente() {
        clienteSeleccion = LISTA_NOMBRES_CLIENTES.getSelectedValue();
        if (clienteSeleccion != null) {
            dispose();
            new InterfazEditaCliente().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona a un cliente");

        }
    }

    public static String obtenerDNICliente() {
        if (clienteSeleccion != null) {
            return clienteSeleccion.getDni();
        } else {
            return "";
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
