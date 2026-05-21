package org.example.Vista;


import org.example.Modelo.Gerente;
import org.example.Modelo.Programador;
import org.example.Modelo.Proyecto;
import org.example.Utils.PresupuestosENUM;
import org.example.Utils.ProyectosENUM;
import org.example.Utils.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import static org.example.ControladorDAO.GerenteDAO.mostrarGerentes;
import static org.example.ControladorDAO.ProgramadorDAO.mostrarProgramadores;
import static org.example.ControladorDAO.ProyectosDAO.comprobarNombreProyecto;
import static org.example.ControladorDAO.ProyectosDAO.insertarProyecto;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class CrearProyecto extends JFrame {

    JTextField txtNombre = new JTextField();

    public CrearProyecto() {
        this.setTitle("Crear un proyecto");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                        null,
                        "⚠️ ¿Seguro que quieres cancelar la creación del proyecto?\n" +
                                "Se perderán todos los datos introducidos.",
                        "Cancelar creación",
                        JOptionPane.YES_NO_OPTION
                );

                if (opcion == JOptionPane.YES_OPTION) {
                    new GestionProyectos().setVisible(true);
                    dispose();
                }
            }
        });

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

        JPanel panelLabels = new JPanel(new GridLayout(3, 1, 5, 5));
        panelLabels.add(crearLabels("Nombre Proy.: "));
        panelLabels.add(crearLabels("Tipo Proy.: "));
        panelLabels.add(crearLabels("Presupuest.: "));

        JComboBox<ProyectosENUM> comboBoxProyectos = new JComboBox<>(ProyectosENUM.values());
        JComboBox<PresupuestosENUM> comboBoxPresupuestos = new JComboBox<>(PresupuestosENUM.values());

        JPanel panelFields = new JPanel(new GridLayout(3, 1, 5, 5));

        txtNombre = crearFields();

        panelFields.add(txtNombre);
        panelFields.add(comboBoxProyectos);
        panelFields.add(comboBoxPresupuestos);

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton btnCrearYAsignarDepto = crearEstiloBotonSubmit("CREAR Y ASIGNAR PROYECTO");
        btnCrearYAsignarDepto.setPreferredSize(new Dimension(380, 45));

        btnCrearYAsignarDepto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText().trim();
                ProyectosENUM proyectosEnum = (ProyectosENUM) comboBoxProyectos.getSelectedItem();
                PresupuestosENUM presupuestoEnum = (PresupuestosENUM) comboBoxPresupuestos.getSelectedItem();

                if (!Validator.camposRellenos(nombre) || proyectosEnum == ProyectosENUM.SELECCIONE_PROYECTO || presupuestoEnum == PresupuestosENUM.SELECCIONE_PRESUPUESTO) {
                    mostrarMensaje("⚠️ Rellene y seleccione los campos");
                    return;
                }

                if (!Validator.validarNombreEmpresa(nombre)) {
                    mostrarMensaje("⚠️ Nombre erroneo. Debe contener letras y o algún signo de puntuación");
                    return;
                }

                String tipoProyecto = Objects.requireNonNull(proyectosEnum).toString();
                double presupuestoProyecto = Objects.requireNonNull(presupuestoEnum).getRandom();

                Date fechaActual = new Date();

                Proyecto proyecto = new Proyecto(nombre, tipoProyecto, presupuestoProyecto, fechaActual, false);

                if (comprobarNombreProyecto(proyecto)) {
                    mostrarMensaje("⚠️ Este proyecto ya existe en el sistema");
                    return;
                }

                ArrayList<Gerente> gerentes = mostrarGerentes();
                ArrayList<Programador> programadores = mostrarProgramadores();

                if (programadores.isEmpty()) {
                    mostrarMensaje("⚠️ No se puede crear un proyecto debido a que no hay programadores");
                    return;
                }


                if (gerentes.isEmpty()) {
                    mostrarMensaje("⚠️ No se puede crear un proyecto debido a que no hay gerentes");
                    return;
                }

                
                if (insertarProyecto(proyecto)) {
                    new AsignarProgramador(proyecto).setVisible(true);
                    dispose();
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
