package org.example.Vista;

import org.example.Modelo.Usuarios;
import org.example.Utils.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.ControladorDAO.UsuariosDAO.*;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class RegistroUser extends JFrame {

    public RegistroUser() {
        this.setTitle("Registro");
        this.setSize(440, 410);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Introduzca sus datos");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelDatosUsuario = getjPanelDatosUsuario();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new Login());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);

    }

    private JPanel getjPanelDatosUsuario() {
        JPanel panelRegistro = new JPanel(new BorderLayout());
        panelRegistro.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 10));

        // Panel central con los labels y los campos
        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JPanel panelLabels = new JPanel(new GridLayout(4, 1, 5, 5));
        panelLabels.add(crearLabels("DNI: "));
        panelLabels.add(crearLabels("Usuario: "));
        panelLabels.add(crearLabels("Contraseña: "));
        panelLabels.add(crearLabels("Confirmar: "));

        JPanel panelFields = new JPanel(new GridLayout(4, 1, 5, 5));
        JTextField txtDni = crearFields();
        JTextField txtUsuario = crearFields();
        JPasswordField txtPassword = new JPasswordField(15);
        JPasswordField txtValidarPasswd = new JPasswordField(15);

        panelFields.add(txtDni);
        panelFields.add(txtUsuario);
        panelFields.add(txtPassword);
        panelFields.add(txtValidarPasswd);

        panelCentro.add(panelLabels);
        panelCentro.add(panelFields);
        panelRegistro.add(panelCentro, BorderLayout.CENTER);

        JPanel panelBoton = new JPanel((new FlowLayout(FlowLayout.CENTER)));

        // Panel del botón centrado abajo
        JButton btnCrearUser = crearEstiloBotonSubmit("CREAR USUARIO");
        btnCrearUser.setPreferredSize(new Dimension(385, 45));
        btnCrearUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(txtPassword.getPassword()).trim();
                String passwordConfirmar = new String(txtValidarPasswd.getPassword()).trim();
                String dni = txtDni.getText().trim();
                String usuario = txtUsuario.getText().trim();

                if (!Validator.camposRellenos(dni, usuario, password, passwordConfirmar)) {
                    mostrarMensaje("⚠️ Rellena todos los campos");
                    return;
                }
                if (!Validator.dniValido(dni)) {
                    mostrarMensaje("⚠️ El DNI debe tener 8 números y una letra");
                    return;
                }
                if (comprobarExistenciaUsuario(new Usuarios(usuario, password, dni))) {
                    mostrarMensaje("⚠️ Este empleado ya tiene un usuario creado");
                    return;
                }
                if (!comprobarUsuarioEmpleado(new Usuarios(usuario, password, dni))) {
                    mostrarMensaje("⚠️ Usted no es empleado, no se le creará el usuario");
                    return;
                }

                if (comprobarNombreUsuarioEmpleado(new Usuarios(usuario, password))) {
                    mostrarMensaje("⚠️ Nombre de usuario existente");
                    return;
                }

                if (!Validator.usuarioValido(usuario)) {
                    mostrarMensaje("⚠️ El usuario debe tener entre 4 y 12 caracteres alfanuméricos");
                    return;
                }
                if (!Validator.passwordValida(password)) {
                    mostrarMensaje("⚠️ La contraseña debe tener al menos 12 caracteres, una mayúscula y un símbolo");
                    return;
                }
                if (!Validator.passwordsCoinciden(password, passwordConfirmar)) {
                    mostrarMensaje("⚠️ Las contraseñas no coinciden");
                    return;
                }

                if (insertarUsuarios(new Usuarios(usuario, password, dni))) {
                    mostrarMensaje("✅ Usuario creado correctamente");
                    dispose();
                    new Login().setVisible(true);
                } else {
                    mostrarMensaje("❌ Error al crear el usuario");
                }
            }
        });

        panelBoton.add(btnCrearUser);


        panelBoton.add(btnCrearUser);
        panelRegistro.add(panelBoton, BorderLayout.SOUTH);


        return panelRegistro;
    }


}
