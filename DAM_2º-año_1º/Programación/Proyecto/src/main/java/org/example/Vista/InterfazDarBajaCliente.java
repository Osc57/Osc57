package org.example.Vista;

import org.example.Modelo.Cliente;
import org.example.Modelo.Recepcionista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.Controlador.ControladorCliente.cargarClientes;
import static org.example.Controlador.ControladorCliente.eliminarCliente;
import static org.example.Controlador.ControladorRecepcionista.cargarTrabajadores;
import static org.example.Vista.InterfazLogin.*;

public class InterfazDarBajaCliente extends JFrame{
    private JList<Cliente> LISTA_NOMBRES_CLIENTES;
    private DefaultListModel<Cliente> MODEL_USUARIO_CLIENTES;

    public InterfazDarBajaCliente(){
        this.setTitle("Dar de Baja");
        this.setSize(460, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel introducirCliente = new JLabel("•Seleccione cliente o Filtre el DNI");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelGestionDni = getjPanelGestionDni();

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelGestionDni, BorderLayout.CENTER);
    }

    private JPanel getjPanelGestionDni(){
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0,15,15,15));


        JPanel panelBoton = new JPanel(new GridLayout(1,2,10,10));

        JButton botonConfirmar = crearEstiloBoton("Confirmar");
        botonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionCliente();
            }
        });

        JButton botonFiltrar = crearEstiloBoton("Filtrar DNI");

        MODEL_USUARIO_CLIENTES = new DefaultListModel<>();
        LISTA_NOMBRES_CLIENTES = new JList<>(MODEL_USUARIO_CLIENTES);

        LISTA_NOMBRES_CLIENTES.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        LISTA_NOMBRES_CLIENTES.setFont(new Font("Arial", Font.PLAIN, 18));
        LISTA_NOMBRES_CLIENTES.setFixedCellHeight(35);
        LISTA_NOMBRES_CLIENTES.setBackground(COLOR_FONDO_GRIS_CLARO);

        JScrollPane jScrollPane = new JScrollPane(LISTA_NOMBRES_CLIENTES);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane.setBorder(BorderFactory.createEmptyBorder(0,0,20,10));

        ArrayList<Cliente> clientes = cargarClientes();
        for (Cliente c : clientes) {
            MODEL_USUARIO_CLIENTES.addElement(c);
        }

        panelBoton.add(botonFiltrar);
        panelBoton.add(botonConfirmar);

        panelPrincipal.add(jScrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;
    }

    private void seleccionCliente() {
        Cliente clienteSeleccion = LISTA_NOMBRES_CLIENTES.getSelectedValue();
        if (clienteSeleccion != null) {
            eliminarCliente(clienteSeleccion.getDni());
            new InterfazDarBajaCliente().setVisible(true);
            dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Selecciona a un trabajador");
        }

    }

    private JTextField crearFields() {
        JTextField field = new JTextField(15);
        field.setFont(FUENTE_CAMPOS);
        field.setPreferredSize(new Dimension(150, 30));

        return field;
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

    public static void main(String[] args) {
        new InterfazDarBajaCliente().setVisible(true);
    }
}
