package org.example.Vista;

import javax.swing.*;

import java.awt.*;

import static org.example.Utils.Estilos.*;

public class ModificarEmpleado extends JFrame {
    public ModificarEmpleado() {
        this.setTitle("Modificar Empleado");
        this.setSize(480, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Seleccione trabajador a modificar");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        //JPanel panelGestionDni = getjPanelGestionDni();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new GestionEmpleado());

        this.add(introducirCliente, BorderLayout.NORTH);
        //this.add(panelGestionDni, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }
}
