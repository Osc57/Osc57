package org.example.Vista;

import org.example.Modelo.Proyecto;

import javax.swing.*;
import java.awt.*;

import static org.example.Utils.Funcionalidad.*;

public class GestionModificarProyecto extends JFrame {

    private JFrame ventanaAnterior;
    private Proyecto proyecto;

    public GestionModificarProyecto(Proyecto p, JFrame ventanaA) {
        this.proyecto = p;
        this.ventanaAnterior = ventanaA;

        this.setTitle("Modifica el proyecto");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("Introduzca los datos del proyecto a modificar");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 50, 0, 0));

        JPanel panelDatosUsuario = getjPanelDatosProyecto();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, ventanaAnterior);

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getjPanelDatosProyecto() {
        JPanel panelPrincipal = new JPanel();


        return panelPrincipal;
    }
}
