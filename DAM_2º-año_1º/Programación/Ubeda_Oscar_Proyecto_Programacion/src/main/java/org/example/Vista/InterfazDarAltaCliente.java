package org.example.Vista;


import org.example.Controlador.ControladorCliente;
import org.example.Modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static org.example.Vista.InterfazLogin.*;

public class InterfazDarAltaCliente extends JFrame {


    private ControladorCliente controladorCliente = new ControladorCliente();

    private JTextField txtDni = new JTextField();
    private JTextField txtNombre = new JTextField();
    private JTextField txtApellidos = new JTextField();
    private JTextField txtDireccion = new JTextField();
    private JTextField txtTelefono = new JTextField();

    public InterfazDarAltaCliente() {
        this.setTitle("Formulario");
        this.setSize(440, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Introduce Los Datos Del Cliente");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelDatosUsuario = getjPanelDatosUsuario();
        JPanel panelBotonRetorno = getjPanelBotonRetorno();

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getjPanelDatosUsuario() {
        JPanel panelPrincipal = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 10));

        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new GridLayout(5, 1, 10, 5));

        panelLabels.add(crearLabels("DNI: "));
        panelLabels.add(crearLabels("Nombre: "));
        panelLabels.add(crearLabels("Apellidos: "));
        panelLabels.add(crearLabels("Dirección: "));
        panelLabels.add(crearLabels("Teléfono: "));

        JPanel panelFields = new JPanel(new GridLayout(5, 1, 5, 5));

        txtDni = crearFields();
        txtNombre = crearFields();
        txtApellidos = crearFields();
        txtDireccion = crearFields();
        txtTelefono = crearFields();

        panelFields.add(txtDni);
        panelFields.add(txtNombre);
        panelFields.add(txtApellidos);
        panelFields.add(txtDireccion);
        panelFields.add(txtTelefono);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 15));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 0));

        JButton btnEliminar = crearEstiloBoton("Borrar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        JButton btnEnviar = crearEstiloBoton("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String validarTelefono = txtTelefono.getText();
                try {
                    if (txtDni.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "DNI, Nombre y Apellidos son campos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);

                    } else if ((!txtDni.getText().matches("[0-9]{8}[A-Za-z]"))) {
                        JOptionPane.showMessageDialog(null, "DNI invalido. Debe tener 8 digitos y una letra", "Error", JOptionPane.INFORMATION_MESSAGE);

                    } else if (!txtNombre.getText().matches("^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+(?: [A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)*$")) {
                        JOptionPane.showMessageDialog(null, "Nombre incorrecto.\nDebe empezar con mayúscula y solo contener letras.", "Error", JOptionPane.ERROR_MESSAGE);

                    } else if (!txtApellidos.getText().matches("^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+(?: [A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)?$")) {
                        JOptionPane.showMessageDialog(null, "Apellido incorrecto.\nDebe empezar con mayúscula y solo contener letras (1 o 2 apellidos).", "Error", JOptionPane.ERROR_MESSAGE);

                    } else if (!validarTelefono.matches("\\d{9}")) {
                        JOptionPane.showMessageDialog(null, "Teléfono inválido. Debe tener 9 digitos", "Error", JOptionPane.ERROR_MESSAGE);

                    } else {
                        Cliente nuevoCliente = new Cliente();
                        nuevoCliente.setDni(txtDni.getText());
                        nuevoCliente.setNombre(txtNombre.getText());
                        nuevoCliente.setApellidos(txtApellidos.getText());
                        nuevoCliente.setDireccion(txtDireccion.getText());
                        nuevoCliente.setTelefono(Integer.parseInt(validarTelefono));

                        if (controladorCliente.enviarDatosCliente(nuevoCliente)) {
                            JOptionPane.showMessageDialog(null, "Cliente registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                            new InterfazGestionaCliente().setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }


                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el formato del teléfono", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panelBotones.add(btnEliminar);
        panelBotones.add(btnEnviar);

        panelPrincipal.add(panelLabels, BorderLayout.WEST);
        panelPrincipal.add(panelFields, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        return panelPrincipal;
    }

    private void limpiarCampos() {
        txtDni.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
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

    private JTextField crearFields() {
        JTextField field = new JTextField(15);
        field.setFont(FUENTE_CAMPOS);
        field.setPreferredSize(new Dimension(150, 30));

        return field;
    }

    private JLabel crearLabels(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(FUENTE_LABEL);
        label.setPreferredSize(new Dimension(120, 30));

        return label;
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
        new InterfazDarAltaCliente().setVisible(true);
    }
}
