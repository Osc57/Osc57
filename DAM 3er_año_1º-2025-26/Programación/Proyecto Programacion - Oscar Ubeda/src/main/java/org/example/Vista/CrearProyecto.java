package org.example.Vista;


import org.example.ControladorDAO.ProgramadorDAO;
import org.example.Modelo.Programador;
import org.example.Modelo.Proyecto;
import org.example.Utils.DepartamentoENUM;
import org.example.Utils.PresupuestosENUM;
import org.example.Utils.ProyectosENUM;
import org.example.Utils.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import static org.example.ControladorDAO.EmpleadosDAO.quedanEmpleadosLibres;
import static org.example.ControladorDAO.ProgramadorDAO.obtenerEmpleadosLibres;
import static org.example.ControladorDAO.ProyectosDAO.insertarProyecto;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class CrearProyecto extends JFrame {

    public CrearProyecto() {
        this.setTitle("Crear un proyecto");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("Introduzca los datos del proyecto");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 0));

        JPanel panelDatosUsuario = getjPanelDatosProyecto();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new GestionProyectos());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    public JPanel getjPanelDatosProyecto() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 10));

        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 30));

        JPanel panelLabels = new JPanel(new GridLayout(2, 1, 5, 5));
        panelLabels.add(crearLabels("Tipo Proy.: "));
        panelLabels.add(crearLabels("Presupuest.: "));

        JComboBox<ProyectosENUM> comboBoxProyectos = new JComboBox<>(ProyectosENUM.values());
        JComboBox<PresupuestosENUM> comboBoxPresupuestos = new JComboBox<>(PresupuestosENUM.values());

        JPanel panelFields = new JPanel(new GridLayout(2, 1, 5, 5));

        panelFields.add(comboBoxProyectos);
        panelFields.add(comboBoxPresupuestos);

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton btnCrearYAsignarDepto = crearEstiloBotonSubmit("CREAR Y ASIGNAR PROYECTO");
        btnCrearYAsignarDepto.setPreferredSize(new Dimension(380, 45));

        btnCrearYAsignarDepto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProyectosENUM proyectosEnum = (ProyectosENUM) comboBoxProyectos.getSelectedItem();
                PresupuestosENUM presupuestoEnum = (PresupuestosENUM) comboBoxPresupuestos.getSelectedItem();

                if (proyectosEnum == ProyectosENUM.SELECCIONE_PROYECTO) {
                    mostrarMensaje("⚠️ Seleccione un proyecto");
                    return;
                }

                if (presupuestoEnum == PresupuestosENUM.SELECCIONE_PRESUPUESTO) {
                    mostrarMensaje("⚠️ Seleccione un presupuesto");
                    return;
                }

                if (!quedanEmpleadosLibres()) {
                    mostrarMensaje("❌ No se pueden dar más proyectos de alta. Todos los empleados están ocupados.");
                    return;
                }

                String nombreProyecto = Objects.requireNonNull(proyectosEnum).toString();
                double presupuestoProyecto = Objects.requireNonNull(presupuestoEnum).getMin();

                Date fechaActual = new Date();

                Proyecto proyecto = new Proyecto(nombreProyecto, presupuestoProyecto, fechaActual, false);

                if (insertarProyecto(proyecto)) {
                    new AsignarProgramador(proyecto).setVisible(true);
                } else {
                    mostrarMensaje("❌ Error al crear el proyecto");
                }

            }
        });


        panelCentro.add(panelLabels);
        panelCentro.add(panelFields);

        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        panelBoton.add(btnCrearYAsignarDepto);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);
        return panelPrincipal;
    }
}
