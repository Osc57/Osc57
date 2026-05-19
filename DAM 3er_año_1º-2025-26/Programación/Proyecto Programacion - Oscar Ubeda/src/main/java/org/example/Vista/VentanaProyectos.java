package org.example.Vista;

import org.example.Modelo.Proyecto;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static org.example.Utils.Funcionalidad.configurarCierreVentana;
import static org.example.Utils.Funcionalidad.getPanelBotonRetorno;

public class VentanaProyectos extends JFrame {

    private JFrame ventanaAnterior;

    public VentanaProyectos(List<Proyecto> proyectos, JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;

        setTitle("Proyectos a cargo");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        configurarCierreVentana(this);

        // Panel donde van los labels
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (Proyecto p : proyectos) {
            JLabel lbl = new JLabel(
                    "• " + p.getNombre() +
                            " | Presupuesto: " + p.getPresupuesto() + "€" +
                            " | Inicio: " + p.getFechaInicio() +
                            " | Finalizado: " + (p.getFinalizado() ? "Sí" : "No")
            );
            lbl.setFont(new Font("Arial", Font.PLAIN, 14));
            panel.add(lbl);
            panel.add(Box.createVerticalStrut(10));
        }

        // Scroll con el panel
        JScrollPane scroll = new JScrollPane(panel);

        // Panel de retorno reutilizable
        JPanel panelRetorno = getPanelBotonRetorno(this, ventanaAnterior);

        // Añadimos correctamente al BorderLayout
        add(scroll, BorderLayout.CENTER);
        add(panelRetorno, BorderLayout.SOUTH);
    }
}

