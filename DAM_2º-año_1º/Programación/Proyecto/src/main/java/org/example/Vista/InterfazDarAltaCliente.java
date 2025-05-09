package org.example.Vista;


import org.example.Controlador.ControladorCliente;
import org.example.Modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazDarAltaCliente extends JFrame {
    private static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 25);
    private static final Font FUENTE_LABEL = new Font("Arial", Font.BOLD, 20);
    private static final Font FUENTE_CAMPOS = new Font("Arial", Font.PLAIN, 20);
    private static final Color COLOR_BOTONES = new Color(70, 130, 180);
    private static final Font FUENTE_BOTONES = new Font("Arial", Font.BOLD, 18);


    public InterfazDarAltaCliente() {
        this.setTitle("Formulario");
        this.setSize(420, 420);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new InterfazGestionaUsuario().setVisible(true);
            }
        });
        */
        JLabel introducirCliente = new JLabel("•Introduce Los Datos Del Cliente");
        introducirCliente.setFont(FUENTE_TITULO);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 0));

        JPanel panelDatosUsuario = getjPanelDatosUsuario();

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario);
    }

    private JPanel getjPanelDatosUsuario() {
        JPanel panelPrincipal = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new GridLayout(5, 1, 10, 5));

        panelLabels.add(crearLabels("DNI: "));
        panelLabels.add(crearLabels("Nombre: "));
        panelLabels.add(crearLabels("Apellidos: "));
        panelLabels.add(crearLabels("Dirección: "));
        panelLabels.add(crearLabels("Teléfono: "));

        JPanel panelFields = new JPanel(new GridLayout(5, 1, 5, 5));

        JTextField txtDni = crearFields();
        JTextField txtNombre = crearFields();
        JTextField txtApellidos = crearFields();
        JTextField txtDireccion = crearFields();
        JTextField txtTelefono = crearFields();

        panelFields.add(txtDni);
        panelFields.add(txtNombre);
        panelFields.add(txtApellidos);
        panelFields.add(txtDireccion);
        panelFields.add(txtTelefono);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 15));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 0));

        JButton btnEliminar = crearEstiloBoton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDni.setText("");
                txtNombre.setText("");
                txtApellidos.setText("");
                txtDireccion.setText("");
                txtTelefono.setText("");
            }
        });

        JButton btnEnviar = crearEstiloBoton("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente nuevoCliente = new Cliente();
                nuevoCliente.setDni(txtDni.getText());
                nuevoCliente.setNombre(txtNombre.getText());
                nuevoCliente.setApellidos(txtApellidos.getText());
                nuevoCliente.setDireccion(txtDireccion.getText());
                nuevoCliente.setTelefono(Integer.parseInt(txtTelefono.getText()));

                new ControladorCliente().enviarDatosCliente(nuevoCliente);

                txtDni.setText("");
                txtNombre.setText("");
                txtApellidos.setText("");
                txtDireccion.setText("");
                txtTelefono.setText("");
            }
        });

        panelBotones.add(btnEliminar);
        panelBotones.add(btnEnviar);

        panelPrincipal.add(panelLabels, BorderLayout.WEST);
        panelPrincipal.add(panelFields, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        return panelPrincipal;
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
        boton.setBackground(COLOR_BOTONES);
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
