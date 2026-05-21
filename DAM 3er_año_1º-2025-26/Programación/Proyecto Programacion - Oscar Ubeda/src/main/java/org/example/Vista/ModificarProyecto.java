package org.example.Vista;

import org.example.Modelo.Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.ControladorDAO.ProyectosDAO.mostrarProyectosFinalizados;
import static org.example.ControladorDAO.ProyectosDAO.mostrarProyectosSinFinalizar;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class ModificarProyecto extends JFrame {

    public ModificarProyecto() {
        this.setTitle("Modificar Pryectos");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel proyectosSeleccion = new JLabel("•Seleccione proyectos a modificar");
        proyectosSeleccion.setFont(FUENTE_TITULO_2);
        proyectosSeleccion.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelScrollPanel = getJPanelBotonesProyect();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new GestionProyectos());

        this.add(proyectosSeleccion, BorderLayout.NORTH);
        this.add(panelScrollPanel, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getJPanelBotonesProyect() {
        JPanel panelPrincipal = new JPanel(new GridLayout(1, 2, 20, 0));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));


        JButton btnProyectoActivo = crearEstiloBoton("<html>Proyectos <br> Sin Finalizar</html>");
        btnProyectoActivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Proyecto> proyectos = mostrarProyectosSinFinalizar();

                if (proyectos.isEmpty()) {
                    mostrarMensaje("⚠️ No hay Proyectos o\n" +
                            "Los proyectos están finalizados");
                    return;
                }

                new ProyectosSinFinalizar().setVisible(true);
                dispose();
            }
        });

        JButton btnProyectoNoActivo = crearEstiloBoton("<html>Proyectos <br> Finalizados</html>");
        btnProyectoNoActivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Proyecto> proyectos = mostrarProyectosFinalizados();

                if (proyectos.isEmpty()) {
                    mostrarMensaje("⚠️ No hay Proyectos o\n" +
                            "Los proyectos no están finalizados");
                    return;
                }

                new ProyectoFinalizado().setVisible(true);
                dispose();

            }
        });

        panelPrincipal.add(btnProyectoActivo);
        panelPrincipal.add(btnProyectoNoActivo);


        return panelPrincipal;
    }

    public static void main(String[] args) {
        new ModificarProyecto().setVisible(true);
    }


}
