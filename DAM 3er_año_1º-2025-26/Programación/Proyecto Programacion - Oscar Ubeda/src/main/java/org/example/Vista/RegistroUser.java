package org.example.Vista;

import org.example.Modelo.Usuarios;
import org.example.Utils.RegistroValidator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.ControladorDAO.UsuariosDAO.*;
import static org.example.Vista.Login.*;

public class RegistroUser extends JFrame {

    public RegistroUser() {
        this.setTitle("Registro");
        this.setSize(440, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Introduzca sus datos");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelDatosUsuario = getjPanelDatosUsuario();
        //JPanel panelBotonRetorno = getjPanelBotonRetorno();

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario, BorderLayout.CENTER);
        //this.add(panelBotonRetorno, BorderLayout.SOUTH);

    }

    private JPanel getjPanelDatosUsuario() {
        JPanel panelRegistro = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelRegistro.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 10));

        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new GridLayout(4, 1, 5, 5));

        panelLabels.add(crearLabels("DNI: "));
        panelLabels.add(crearLabels("Usuario: "));
        panelLabels.add(crearLabels("Contraseña: "));
        panelLabels.add(crearLabels("Confirmar: "));

        JPanel panelFields = new JPanel(new GridLayout(4, 1, 5, 5));

        JTextField txtDni = crearFields();
        JTextField txtUsuario = crearFields();
        JPasswordField txtPassword = new JPasswordField(15);
        txtPassword.setPreferredSize(new Dimension(150, 30));

        JPasswordField txtValidarPasswd = new JPasswordField(15);
        txtValidarPasswd.setPreferredSize(new Dimension(150, 30));

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER, 70, 15));
        panelBoton.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 0));

        JButton btnCrearUser = crearEstiloBoton("CREAR USUARIO");
        btnCrearUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String password = new String(txtPassword.getPassword()).trim();
                String passwordConfirmar = new String(txtValidarPasswd.getPassword()).trim();
                String dni = txtDni.getText().trim();
                String usuario = txtUsuario.getText().trim();

                //Campos vacíos
                if (!RegistroValidator.camposRellenos(dni, usuario, password, passwordConfirmar)) {
                    JOptionPane.showMessageDialog(null, "⚠️ Rellena todos los campos");
                    return;
                }

                //DNI valido
                if (!RegistroValidator.dniValido(dni)) {
                    JOptionPane.showMessageDialog(null, "⚠️ El DNI debe tener 8 números y una letra");
                    return;
                }

                //Comprobar si tiene usuario
                if (comprobarExistenciaUsuario(new Usuarios(usuario, password, dni))) {
                    JOptionPane.showMessageDialog(null, "⚠️ Este empleado ya tiene un usuario creado");
                    return;
                }

                //Comprobar si es empleado
                if (!comprobarUsuarioEmpleado(new Usuarios(usuario, password, dni))) {
                    JOptionPane.showMessageDialog(null, "⚠️ Usted no es empleado, no se le creará el usuario");
                    return;
                }

                //Usuario valido
                if (!RegistroValidator.usuarioValido(usuario)) {
                    JOptionPane.showMessageDialog(null, "⚠️ El usuario debe tener entre 4 y 12 caracteres alfanuméricos");
                    return;
                }

                //Contraseña valida
                if (!RegistroValidator.passwordValida(password)) {
                    JOptionPane.showMessageDialog(null, "⚠️ La contraseña debe tener al menos 12 caracteres, una mayúscula y un símbolo");
                    return;
                }

                //Coinciden las contraseñas
                if (!RegistroValidator.passwordsCoinciden(password, passwordConfirmar)) {
                    JOptionPane.showMessageDialog(null, "⚠️ Las contraseñas no coinciden");
                    return;
                }

                //Insertar usuario
                if (insertarUsuarios(new Usuarios(usuario, password, dni))) {
                    JOptionPane.showMessageDialog(null, "✅ Usuario creado correctamente");
                    dispose();
                    new SacarDatosUsuarios().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "❌ Error al crear el usuario");
                }
            }
        });


        panelFields.add(txtDni);
        panelFields.add(txtUsuario);
        panelFields.add(txtPassword);
        panelFields.add(txtValidarPasswd);
        panelBoton.add(btnCrearUser);

        panelRegistro.add(panelLabels, BorderLayout.WEST);
        panelRegistro.add(panelFields, BorderLayout.CENTER);
        panelRegistro.add(panelBoton, BorderLayout.SOUTH);

        return panelRegistro;
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

}
