package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Controlador.ControladorCliente.dniCliente;
import static org.example.Vista.InterfazLogin.*;

public class InterfazFiltrarDNI extends JFrame {

    private JTextField fieldDNI = new JTextField();

    public InterfazFiltrarDNI(){
        this.setTitle("Filtrar DNI");
        this.setSize(360, 240);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel tituloFiltrar = new JLabel("•Introduce un DNI");
        tituloFiltrar.setFont(FUENTE_TITULO_2);
        tituloFiltrar.setBorder(BorderFactory.createEmptyBorder(15, 60, 15, 0));


        JPanel panelDNI = getjPanelPanelDNI();


        this.add(tituloFiltrar, BorderLayout.NORTH);
        this.add(panelDNI);
    }

    private JPanel getjPanelPanelDNI() {
        JPanel panelGuardar = new JPanel(new BorderLayout());
        JPanel pField = new JPanel();

        JPanel pBoton = new JPanel(new GridLayout(1,1));
        pBoton.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton bEnviar = crearEstiloBoton("Filtrar");
        bEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fieldDNI.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Introduzca el DNI", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!fieldDNI.getText().matches("[0-9]{8}[A-Za-z]")) {
                        JOptionPane.showMessageDialog(null, "DNI invalido. Debe tener 8 digitos y una letra", "Error", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    dniCliente(fieldDNI.getText());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        fieldDNI = crearFields();

        pField.add(fieldDNI);
        pBoton.add(bEnviar);

        panelGuardar.add(pField, BorderLayout.CENTER);
        panelGuardar.add(pBoton, BorderLayout.SOUTH);
        return  panelGuardar;
    }

    private JTextField crearFields() {
        JTextField field = new JTextField(15);
        field.setFont(FUENTE_CAMPOS);
        field.setPreferredSize(new Dimension(150, 30));

        return field;
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
        new InterfazFiltrarDNI().setVisible(true);
    }
}
