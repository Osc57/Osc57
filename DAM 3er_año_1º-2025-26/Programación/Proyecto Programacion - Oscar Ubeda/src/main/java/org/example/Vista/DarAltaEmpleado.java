package org.example.Vista;

import org.example.Modelo.Empleados;
import org.example.Utils.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.ControladorDAO.EmpleadosDAO.comprobarEmpleados;
import static org.example.Utils.Estilos.*;
import static org.example.Utils.Messages.mostrarError;

public class DarAltaEmpleado extends JFrame {

    private JTextField txtDni;
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtTelefono;
    private JTextField txtEmail;

    private JRadioButton rbSi;
    private JRadioButton rbNo;

    public DarAltaEmpleado() {
        this.setTitle("Dar De Alta");
        this.setSize(500, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("Introduzca los datos del empleado");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 50, 0, 0));

        JPanel panelDatosUsuario = getjPanelDatosUsuario();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new GestionEmpleado());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getjPanelDatosUsuario() {
        JPanel panelRegistro = new JPanel(new BorderLayout());
        panelRegistro.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 10));

        // Panel central con los labels y los campos
        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JPanel panelLabels = new JPanel(new GridLayout(7, 1, 5, 5));
        panelLabels.add(crearLabels("DNI: "));
        panelLabels.add(crearLabels("Nombre: "));
        panelLabels.add(crearLabels("Apellidos: "));
        panelLabels.add(crearLabels("Teléfono: "));
        panelLabels.add(crearLabels("Email: "));
        panelLabels.add(crearLabels("¿Gerente?: "));

        JPanel panelFields = new JPanel(new GridLayout(7, 1, 5, 5));
        txtDni = crearFields();
        txtNombre = crearFields();
        txtApellidos = crearFields();
        txtTelefono = crearFields();
        txtEmail = crearFields();

        panelFields.add(txtDni);
        panelFields.add(txtNombre);
        panelFields.add(txtApellidos);
        panelFields.add(txtTelefono);
        panelFields.add(txtEmail);

        JPanel panelGerente = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelGerente.setOpaque(false);

        rbSi = crearRadioButtonEstilizado("Sí", false);
        rbNo = crearRadioButtonEstilizado("No", false);


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
        JButton btnCrearUser = crearEstiloBotonSubmit("SIGUIENTE");

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
                    mostrarError("⚠️ Rellene todos los campos de texto.");
                    return;
                }

                if (!rbSi.isSelected() && !rbNo.isSelected()) {
                    mostrarError("⚠️ Seleccione una opción para Gerente.");
                    return;
                }

                if (!Validator.dniValido(dni)) {
                    mostrarError("⚠️ El DNI debe tener 8 números y una letra");
                    return;
                }

                if (!Validator.nombreValido(nombre)) {
                    mostrarError("⚠️ El nombre debe empezar por mayúscula y ser letras");
                    return;
                }

                if (!Validator.apellidosValido(apellidos)) {
                    mostrarError("⚠️ El apellido debe empezar por mayúscula y ser letras");
                    return;
                }

                if (!Validator.telefonoValido(telefono)) {
                    mostrarError("⚠️ El teléfono deben ser 9 números");
                    return;
                }

                if (!Validator.validarEmail(email)) {
                    mostrarError("⚠️ El email debe ser válido (Ej. example@correo.com)");
                    return;
                }

                Empleados empleado = new Empleados(dni, nombre, apellidos, email, telefono);
                if (comprobarEmpleados(empleado)) {
                    mostrarError("⚠️ Este empelado ya existe en la empresa");
                    return;
                }

                //Ocultar this para mantener datos por si quiere volver atrás
                if (esGerente) {
                    setVisible(false);
                    new EmpleadoGerente(DarAltaEmpleado.this, empleado).setVisible(true);
                } else {
                    setVisible(false);
                    new EmpleadoProgramador(DarAltaEmpleado.this, empleado).setVisible(true);
                }


            }
        });

        panelRegistro.add(panelBoton, BorderLayout.SOUTH);

        return panelRegistro;
    }
}
