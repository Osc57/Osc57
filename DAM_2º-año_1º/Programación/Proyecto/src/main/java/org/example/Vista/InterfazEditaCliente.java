package org.example.Vista;

import org.example.Modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Controlador.ControladorCliente.editarCliente;
import static org.example.Vista.InterfazLogin.*;
import static org.example.Vista.InterfazLogin.COLOR_BOTONES_AZUL;
import static org.example.Vista.InterfazLogin.COLOR_BOTON_GRIS_CLARO;
import static org.example.Vista.InterfazLogin.FUENTE_BOTONES;
import static org.example.Vista.InterfazLogin.FUENTE_CAMPOS;
import static org.example.Vista.InterfazLogin.FUENTE_EMOJI;
import static org.example.Vista.InterfazLogin.FUENTE_LABEL;

public class InterfazEditaCliente extends JFrame {
    private JTextField txtDni = new JTextField();
    private JTextField txtNombre = new JTextField();
    private JTextField txtApellidos = new JTextField();
    private JTextField txtDireccion = new JTextField();
    private JTextField txtTelefono = new JTextField();

    public InterfazEditaCliente() {
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

                    if (!txtNombre.getText().matches("^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+(?: [A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)*$")) {
                        JOptionPane.showMessageDialog(null, "Nombre incorrecto.\nDebe empezar con mayúscula y solo contener letras.", "Error", JOptionPane.ERROR_MESSAGE);

                    } else if (!txtApellidos.getText().matches("^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+(?: [A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)?$")) {
                        JOptionPane.showMessageDialog(null, "Apellido incorrecto.\nDebe empezar con mayúscula y solo contener letras (1 o 2 apellidos).", "Error", JOptionPane.ERROR_MESSAGE);

                    } else if (!validarTelefono.matches("\\d{9}")) {
                        JOptionPane.showMessageDialog(null, "Teléfono inválido. Debe tener 9 digitos", "Error", JOptionPane.ERROR_MESSAGE);

                    } else {
                        Cliente clienteEditado = new Cliente();
                        clienteEditado.setNombre(txtNombre.getText());
                        clienteEditado.setApellidos(txtApellidos.getText());
                        clienteEditado.setDireccion(txtDireccion.getText());
                        clienteEditado.setTelefono(Integer.parseInt(validarTelefono));

                        
                        if (editarCliente(clienteEditado.getNombre(), clienteEditado.getApellidos(), clienteEditado.getDireccion(), clienteEditado.getTelefono())) {
                            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo registrar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
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
        new InterfazEditaCliente().setVisible(true);
    }
}
