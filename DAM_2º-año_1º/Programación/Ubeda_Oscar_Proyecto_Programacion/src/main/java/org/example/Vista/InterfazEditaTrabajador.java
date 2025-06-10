package org.example.Vista;

import org.example.Controlador.ControladorCliente;
import org.example.Controlador.ControladorTrabajador;
import org.example.Modelo.Cliente;
import org.example.Modelo.Trabajador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Controlador.ControladorCliente.obtenerClientePorDNI;
import static org.example.Controlador.ControladorTrabajador.*;
import static org.example.Vista.InterfazDarBajaTrabajador.LISTA_NOMBRES_TRABAJADORES;
import static org.example.Vista.InterfazDarBajaTrabajador.MODEL_USUARIO_TRABAJADORES;
import static org.example.Vista.InterfazLogin.*;
import static org.example.Vista.InterfazLogin.COLOR_BOTONES_AZUL;
import static org.example.Vista.InterfazLogin.FUENTE_BOTONES;
import static org.example.Vista.InterfazLogin.FUENTE_LABEL;

public class InterfazEditaTrabajador extends JFrame {

    private JTextField txtNombre = new JTextField();
    private JTextField txtApellidos = new JTextField();
    private JTextField txtTelefono = new JTextField();

    public InterfazEditaTrabajador(){
        this.setTitle("Editar Trabajador");
        this.setSize(430, 420);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Edita Los Datos Del Trabajador");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelDatosUsuario = getjPanelDatosTrabajador();
        JPanel panelBotonRetorno = getjPanelBotonRetorno();

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getjPanelDatosTrabajador() {
        JPanel panelPrincipal = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 10));

        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new GridLayout(4, 1, 10, 5));

        panelLabels.add(crearLabels("Nombre: "));
        panelLabels.add(crearLabels("Apellidos: "));
        panelLabels.add(crearLabels("Teléfono: "));

        JPanel panelFields = new JPanel(new GridLayout(4, 1, 5, 5));

        txtNombre = crearFields();
        txtApellidos = crearFields();
        txtTelefono = crearFields();

        panelFields.add(txtNombre);
        panelFields.add(txtApellidos);
        panelFields.add(txtTelefono);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(0, 4, 15, 5));

        JButton btnMostrar = crearEstiloBoton("Mostrar Datos");
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTrabajador();
            }
        });

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
                cambiarTrabajador();
            }
        });


        panelBotones.add(btnEliminar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnEnviar);

        panelPrincipal.add(panelLabels, BorderLayout.WEST);
        panelPrincipal.add(panelFields, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        return panelPrincipal;
    }

    public void cambiarTrabajador() {
        String dniTrabajador = InterfazSeleccionEditarTrabajador.obtenerDNITrabajador();

        try {
            Trabajador clienteActual = obtenerTrabajadorPorDNI(dniTrabajador);

            if (clienteActual == null) {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Trabajador datosModificados = new Trabajador();
            datosModificados.setDni(clienteActual.getDni());
            datosModificados.setNombre(clienteActual.getNombre());
            datosModificados.setApellidos(clienteActual.getApellidos());
            datosModificados.setTelefono(clienteActual.getTelefono());

            String nombre = txtNombre.getText().trim();
            String apellidos = txtApellidos.getText().trim();
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

            if (!telefonoTexto.isEmpty()) {
                if (!telefonoTexto.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Error el teléfono solo debe contener números", "Error", JOptionPane.ERROR_MESSAGE);
                    datosValidos = false;
                } else if (telefonoTexto.length() != 9) {
                    JOptionPane.showMessageDialog(null, "Error el teléfono debe contener 9 digitos", "Error", JOptionPane.ERROR_MESSAGE);
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

            if (ControladorTrabajador.editarTrabajador(
                    datosModificados.getDni(),
                    datosModificados.getNombre(),
                    datosModificados.getApellidos(),
                    datosModificados.getTelefono())) {

                JOptionPane.showMessageDialog(null, "Trabajador editado con éxito");
                dispose();
                new InterfazGestionJefe().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error al editar el trabajador", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos del trabajador: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarTrabajador(){
        JDialog dialog = new JDialog(this, "Datos del Trabajador", false);
        dialog.setSize(300, 160);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);
        dialog.setLayout(new BorderLayout());

        Trabajador trabajador = mostrarDatosTrabajador(InterfazSeleccionEditarTrabajador.obtenerDNITrabajador());

        JTextArea textArea = new JTextArea(trabajador.datosTrabajaoor());
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 18));
        textArea.setBackground(COLOR_FONDO_GRIS_CLARO);

        dialog.add(new JScrollPane(textArea), BorderLayout.CENTER);
        dialog.setVisible(true);
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
                new InterfazSeleccionEditarTrabajador().setVisible(true);
            }
        });
        return panelBotonRetorno;
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

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
    }

    public static void main(String[] args) {
        new InterfazEditaTrabajador().setVisible(true);
    }

}
