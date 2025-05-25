package org.example.Vista;

import org.example.Controlador.ControladorCliente;
import org.example.Modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Controlador.ControladorCliente.*;
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
        this.setSize(420, 420);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Edita Los Datos Del Cliente");
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
        panelLabels.setLayout(new GridLayout(4, 1, 10, 5));

        panelLabels.add(crearLabels("Nombre: "));
        panelLabels.add(crearLabels("Apellidos: "));
        panelLabels.add(crearLabels("Dirección: "));
        panelLabels.add(crearLabels("Teléfono: "));

        JPanel panelFields = new JPanel(new GridLayout(4, 1, 5, 5));

        txtNombre = crearFields();
        txtApellidos = crearFields();
        txtDireccion = crearFields();
        txtTelefono = crearFields();

        panelFields.add(txtNombre);
        panelFields.add(txtApellidos);
        panelFields.add(txtDireccion);
        panelFields.add(txtTelefono);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 45, 15));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(0, 5, 15, 0));

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
                cambiarCliente();
            }
        });

        panelBotones.add(btnEliminar);
        panelBotones.add(btnEnviar);

        panelPrincipal.add(panelLabels, BorderLayout.WEST);
        panelPrincipal.add(panelFields, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        return panelPrincipal;
    }

    public void cambiarCliente() {
        String dniCliente = InterfazGestionEditaCliente.obtenerDNICliente();

        try {
            Cliente clienteActual = obtenerClientePorDNI(dniCliente);

            if (clienteActual == null) {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Cliente datosModificados = new Cliente();
            datosModificados.setDni(clienteActual.getDni());
            datosModificados.setNombre(clienteActual.getNombre());
            datosModificados.setApellidos(clienteActual.getApellidos());
            datosModificados.setDireccion(clienteActual.getDireccion());
            datosModificados.setTelefono(clienteActual.getTelefono());

            String nombre = txtNombre.getText().trim();
            String apellidos = txtApellidos.getText().trim();
            String direccion = txtDireccion.getText().trim();
            String telefonoTexto = txtTelefono.getText().trim();

            // Validación de campos
            boolean datosValidos = true;

            // Validar nombre (solo letras y espacios)
            if (!nombre.isEmpty()) {
                if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                    JOptionPane.showMessageDialog(null, "Nombre incorrecto.\nDebe empezar con mayúscula y solo contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                } else if (!nombre.equals(clienteActual.getNombre())) {
                    datosModificados.setNombre(nombre);
                }
            }

            if (!apellidos.isEmpty()) {
                if (!apellidos.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                    JOptionPane.showMessageDialog(null, "Apellido incorrecto.\nDebe empezar con mayúscula y solo contener letras (1 o 2 apellidos).", "Error", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                } else if (!apellidos.equals(clienteActual.getApellidos())) {
                    datosModificados.setApellidos(apellidos);
                }
            }

            if (!direccion.isEmpty() && !direccion.equals(clienteActual.getDireccion())) {
                datosModificados.setDireccion(direccion);
            }

            if (!telefonoTexto.isEmpty()) {
                if (!telefonoTexto.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Error el teléfono solo debe contener números", "Error", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                } else if (telefonoTexto.length() != 9) {
                    JOptionPane.showMessageDialog(null, "Error el teléfoo dee contener 9 digitos", "Error", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                } else {
                    try {
                        Integer telefono = Integer.parseInt(telefonoTexto);
                        if (!telefono.equals(clienteActual.getTelefono())) {
                            datosModificados.setTelefono(telefono);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error teléfono invalido", "Error", JOptionPane.ERROR_MESSAGE);
                        datosValidos = false;
                    }
                }
            }

            if (!datosValidos) {
                JOptionPane.showMessageDialog(null, "Error en los datos proporcionados", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (ControladorCliente.editarCliente(
                    datosModificados.getDni(),
                    datosModificados.getNombre(),
                    datosModificados.getApellidos(),
                    datosModificados.getDireccion(),
                    datosModificados.getTelefono())) {

                JOptionPane.showMessageDialog(null, "Cliente editado con éxito");
                dispose();
                new InterfazGestionaCliente().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error al editar el cliente", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos del cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        panelBotonRetorno.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 250));
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



