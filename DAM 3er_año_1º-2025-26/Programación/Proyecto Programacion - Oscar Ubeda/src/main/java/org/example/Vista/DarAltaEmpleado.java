package org.example.Vista;

import org.example.Modelo.Usuarios;
import org.example.Utils.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.ControladorDAO.UsuariosDAO.*;
import static org.example.ControladorDAO.UsuariosDAO.insertarUsuarios;
import static org.example.Vista.Login.*;
import static org.example.Vista.Login.FUENTE_EMOJI;

public class DarAltaEmpleado extends JFrame {

    public DarAltaEmpleado() {
        this.setTitle("Dar De Alta");
        this.setSize(500, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("Introduzca los datos del empleado");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 50, 0, 0));

        JPanel panelDatosUsuario = getjPanelDatosUsuario();
        JPanel panelBotonRetorno = getjPanelBotonRetorno();

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getjPanelDatosUsuario() {
        JPanel panelRegistro = new JPanel(new BorderLayout());
        panelRegistro.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 10));

        // Panel central con los labels y los campos
        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JPanel panelLabels = new JPanel(new GridLayout(6, 1, 5, 5));
        panelLabels.add(crearLabels("DNI: "));
        panelLabels.add(crearLabels("Nombre: "));
        panelLabels.add(crearLabels("Apellidos: "));
        panelLabels.add(crearLabels("Teléfono: "));
        panelLabels.add(crearLabels("Email: "));
        panelLabels.add(crearLabels("¿Gerente?: "));

        JPanel panelFields = new JPanel(new GridLayout(6, 1, 5, 5));
        JTextField txtDni = crearFields();
        JTextField txtNombre = crearFields();
        JTextField txtApellidos = crearFields();
        JTextField txtTelefono = crearFields();
        JTextField txtEmail = crearFields();

        panelFields.add(txtDni);
        panelFields.add(txtNombre);
        panelFields.add(txtApellidos);
        panelFields.add(txtTelefono);
        panelFields.add(txtEmail);

        JPanel panelGerente = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelGerente.setOpaque(false);

        JRadioButton rbSi = crearRadioButtonEstilizado("Sí", false);
        JRadioButton rbNo = crearRadioButtonEstilizado("No", false);


        ButtonGroup grupoGerente = new ButtonGroup();
        grupoGerente.add(rbSi);
        grupoGerente.add(rbNo);

        JPanel panelRadioGerente = new JPanel(new GridLayout(1, 2));
        panelRadioGerente.setOpaque(false);
        panelRadioGerente.add(rbSi);
        panelRadioGerente.add(rbNo);

        panelFields.add(panelRadioGerente);

        panelCentro.add(panelLabels);
        panelCentro.add(panelFields);
        panelRegistro.add(panelCentro, BorderLayout.CENTER);

        // Panel del botón centrado abajo
        JPanel panelBoton = new JPanel((new FlowLayout(FlowLayout.CENTER)));
        JButton btnCrearUser = crearEstiloBoton("SIGUIENTE");

        btnCrearUser.setPreferredSize(new Dimension(380, 45));
        panelBoton.add(btnCrearUser);

        btnCrearUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = txtDni.getText().trim();
                String nombre = txtNombre.getText().trim();
                String apellidos = txtApellidos.getText().trim();
                String telefono = txtTelefono.getText().trim();
                String email = txtEmail.getText().trim();
                boolean esGerente = rbSi.isSelected();

                if (!Validator.camposRellenos(dni, nombre, apellidos, telefono, email)) {
                    JOptionPane.showMessageDialog(null, "⚠️ Rellene todos los campos de texto.");
                    return;
                }

                if (!rbSi.isSelected() && !rbNo.isSelected()) {
                    JOptionPane.showMessageDialog(null, "⚠️ Seleccione una opción para Gerente.");
                    return;
                }

            }
        });

        panelRegistro.add(panelBoton, BorderLayout.SOUTH);

        return panelRegistro;
    }

    private JTextField crearFields() {
        JTextField field = new JTextField(19);
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
                BorderFactory.createEmptyBorder(10, 50, 10, 45)
        ));
        return boton;
    }

    private JRadioButton crearRadioButtonEstilizado(String texto, boolean seleccionado) {
        JRadioButton rb = new JRadioButton(texto, seleccionado);

        // Estética: Fuente, color y quitar el borde de foco
        rb.setFont(FUENTE_LABEL);
        rb.setFocusPainted(false);
        rb.setOpaque(false); // Para que tome el color del panel de fondo
        rb.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return rb;
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
                new GestionEmpleado().setVisible(true);
            }
        });
        return panelBotonRetorno;
    }

    public static void main(String[] args) {
        new DarAltaEmpleado().setVisible(true);
    }
}
