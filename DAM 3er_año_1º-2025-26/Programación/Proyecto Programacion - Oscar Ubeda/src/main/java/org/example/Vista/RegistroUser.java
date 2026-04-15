package org.example.Vista;

import javax.swing.*;
import java.awt.*;

import static org.example.Vista.Login.*;

public class RegistroUser extends JFrame {

    private JTextField txtDni = new JTextField();
    private JTextField txtUsuario = new JTextField();

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

        txtDni = crearFields();
        txtUsuario = crearFields();
        JPasswordField txtPassword = new JPasswordField(15);
        txtPassword.setPreferredSize(new Dimension(150, 30));

        JPasswordField txtValidarPasswd = new JPasswordField(15);
        txtValidarPasswd.setPreferredSize(new Dimension(150, 30));

        panelFields.add(txtDni);
        panelFields.add(txtUsuario);
        panelFields.add(txtPassword);
        panelFields.add(txtValidarPasswd);

        panelRegistro.add(panelLabels, BorderLayout.WEST);
        panelRegistro.add(panelFields, BorderLayout.CENTER);

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

}
