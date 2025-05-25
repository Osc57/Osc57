package org.example.Vista;

import org.example.Controlador.ControladorJefe;
import org.example.Controlador.ControladorRecepcionista;
import org.example.Modelo.Jefe;
import org.example.Modelo.Recepcionista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Vista.InterfazLogin.*;

public class InterfazDarAltaTrabajador extends JFrame {

    private JTextField txtDni = new JTextField();
    private JTextField txtNombre = new JTextField();
    private JTextField txtApellidos = new JTextField();
    private JTextField txtTelefono = new JTextField();
    private JCheckBox chbJefe = new JCheckBox();

    public InterfazDarAltaTrabajador() {
        this.setTitle("Formulario");
        this.setSize(480, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Introduce Los Datos Del Trabajador");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

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
        panelLabels.add(crearLabels("Teléfono: "));
        panelLabels.add(crearLabels("¿Es Jefe?: "));

        JPanel panelFields = new JPanel(new GridLayout(5, 1, 5, 5));

        txtDni = crearFields();
        txtNombre = crearFields();
        txtApellidos = crearFields();
        txtTelefono = crearFields();

        panelFields.add(txtDni);
        panelFields.add(txtNombre);
        panelFields.add(txtApellidos);
        panelFields.add(txtTelefono);
        panelFields.add(chbJefe);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 70, 15));
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

                        if (chbJefe.isSelected()) {
                            Jefe nevoJefe = new Jefe();
                            nevoJefe.setDni(txtDni.getText());
                            nevoJefe.setNombre(txtNombre.getText());
                            nevoJefe.setApellidos(txtApellidos.getText());
                            nevoJefe.setTelefono(Integer.parseInt(validarTelefono));

                            if (new ControladorJefe().enviarDatosJefe(nevoJefe)) {
                                JOptionPane.showMessageDialog(null, "Jefe registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                limpiarCampos();
                            } else {
                                JOptionPane.showMessageDialog(null, "No se pudo registrar el jefe", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        } else {
                            Recepcionista nuevoTrabajador = new Recepcionista();
                            nuevoTrabajador.setDni(txtDni.getText());
                            nuevoTrabajador.setNombre(txtNombre.getText());
                            nuevoTrabajador.setApellidos(txtApellidos.getText());
                            nuevoTrabajador.setTelefono(Integer.parseInt(validarTelefono));

                            String dniJefe = InterfazSeleccionJefe.obtenerDNIJefe();
                            if (dniJefe.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "No se hay un jefe seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            if (new ControladorRecepcionista().enviarDatosRecepcionista(nuevoTrabajador, dniJefe)) {
                                JOptionPane.showMessageDialog(null, "Trabajador registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                dispose();
                                new InterfazGestionJefe().setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "No se pudo registrar el trabajador", "Error", JOptionPane.ERROR_MESSAGE);
                            }

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
        txtTelefono.setText("");
        chbJefe.setSelected(false);
    }

    private JPanel getjPanelBotonRetorno() {
        JPanel panelBotonRetorno = new JPanel(new BorderLayout());
        JButton botonRetorno = new JButton("←");
        panelBotonRetorno.add(botonRetorno, BorderLayout.SOUTH);
        panelBotonRetorno.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 320));
        panelBotonRetorno.setBackground(COLOR_FONDO_GRIS_CLARO);

        botonRetorno.setFocusPainted(false);
        botonRetorno.setBackground(COLOR_BOTON_GRIS_CLARO);
        botonRetorno.setFont(FUENTE_EMOJI);

        botonRetorno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InterfazGestionJefe().setVisible(true);
            }
        });
        return panelBotonRetorno;
    }

    private JTextField crearFields() {
        JTextField field = new JTextField(20);
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
        new InterfazDarAltaTrabajador().setVisible(true);
    }
}

