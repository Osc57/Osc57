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

        this.setTitle("Proyectos a cargo");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        configurarCierreVentana(this);

        // Panel donde van los labels
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 20));


        for (Proyecto p : proyectos.stream()
                .filter(pr -> !pr.getFinalizado())
                .toList()) {

            JLabel lbl = new JLabel(
                    "• Nombre Proyecto: " + p.getNombre() +
                            " | Tipo: " + p.getTipo() +
                            " | Presupuesto: " + p.getPresupuesto() + "€" +
                            " | Inicio: " + p.getFechaInicio() +
                            " | Finalizado: No"
            );

            lbl.setFont(new Font("Arial", Font.PLAIN, 18));
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

