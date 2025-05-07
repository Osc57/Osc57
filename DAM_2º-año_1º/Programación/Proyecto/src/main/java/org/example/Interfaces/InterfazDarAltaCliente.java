package org.example.Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfazDarAltaCliente extends JFrame {
    private static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 25);
    private static final Font FUENTE_LABEL = new Font("Arial", Font.BOLD, 18);
    private static final Font FUENTE_CAMPOS = new Font("Arial", Font.PLAIN, 16);

    public InterfazDarAltaCliente() {
        this.setTitle("Formulario");
        this.setSize(450, 500);
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

        JPanel panelDatosUsuario = getjPanelDatosUsuario();

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario);
    }

    private JPanel getjPanelDatosUsuario() {
        JPanel panelDatos = new JPanel();
        JPanel panelLabel = new JPanel();
        panelLabel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel panelField = new JPanel();
        panelField.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel dni = estilosLabelDatosCliente("DNI: ");
        JTextField dniField = estilosFieldDatosCliente();

        JLabel nombre = estilosLabelDatosCliente("Nombre: ");
        JTextField nombreField = estilosFieldDatosCliente();

        JLabel apellidos = estilosLabelDatosCliente("Apellidos: ");
        JTextField apellidosField = estilosFieldDatosCliente();

        JLabel direccion = estilosLabelDatosCliente("Dirección: ");
        JTextField direccionField = estilosFieldDatosCliente();

        JLabel telefono = estilosLabelDatosCliente("Teléfono: ");
        JTextField telefonoField = estilosFieldDatosCliente();

        JButton enviarDatos = new JButton("Enviar");

        panelLabel.add(dni);
        panelField.add(dniField);

        panelLabel.add(nombre);
        panelField.add(nombreField);

        panelLabel.add(apellidos);
        panelField.add(apellidosField);

        panelLabel.add(direccion);
        panelField.add(direccionField);

        panelLabel.add(telefono);
        panelField.add(telefonoField);

        panelDatos.add(panelLabel);
        panelDatos.add(panelField);

        return panelDatos;
    }

    private JLabel estilosLabelDatosCliente(String nombre) {
        JLabel estilosDatosUsuarios = new JLabel(nombre);
        estilosDatosUsuarios.setFont(FUENTE_LABEL);

        return estilosDatosUsuarios;
    }

    private JTextField estilosFieldDatosCliente() {
        JTextField textoDatosUsuario = new JTextField(15);
        textoDatosUsuario.setFont(FUENTE_CAMPOS);

        return textoDatosUsuario;
    }

    public static void main(String[] args) {
        new InterfazDarAltaCliente().setVisible(true);
    }
}
