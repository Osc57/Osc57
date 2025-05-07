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
        this.setSize(450, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new InterfazGestionaUsuario().setVisible(true);
            }
        });

        JLabel introducirCliente = new JLabel("•Introduce Los Datos Del Cliente");
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(20, 23, 20, 0));
        introducirCliente.setHorizontalAlignment(SwingConstants.LEFT);
        introducirCliente.setFont(FUENTE_TITULO);

        JPanel panelDatosUsuario = getjPanelDatosUsuario();

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario);
    }

    private JPanel getjPanelDatosUsuario() {
        JPanel panelDatos = new JPanel(new GridLayout(5, 2, 20, 20));

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

        panelDatos.add(dni);
        panelDatos.add(nombre,nombreField);
        panelDatos.add(apellidos);
        panelDatos.add(direccion);
        panelDatos.add(telefono);
        return panelDatos;
    }
    private JLabel estilosLabelDatosCliente(String nombre){
        JLabel estilosDatosUsuarios = new JLabel(nombre);
        estilosDatosUsuarios.setFont(FUENTE_LABEL);

        return estilosDatosUsuarios;
    }

    private JTextField estilosFieldDatosCliente(){
        JTextField textoDatosUsuario = new JTextField(20);
        textoDatosUsuario.setFont(FUENTE_CAMPOS);

        return textoDatosUsuario;
    }

    public static void main(String[] args) {
        new InterfazDarAltaCliente().setVisible(true);
    }
}
