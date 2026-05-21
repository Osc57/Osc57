package org.example.Vista;

import org.example.Modelo.Proyecto;
import org.example.Utils.PresupuestosENUM;
import org.example.Utils.ProyectosENUM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.ControladorDAO.ProyectosDAO.*;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class GestionModificarProyecto extends JFrame {

    private JFrame ventanaAnterior;
    private Proyecto proyecto;
    JTextField txtNombre = new JTextField();

    public GestionModificarProyecto(Proyecto p, JFrame ventanaA) {
        this.proyecto = p;
        this.ventanaAnterior = ventanaA;

        this.setTitle("Modifica el proyecto");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("Modifique los datos del Proyecto");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 50, 0, 0));

        JPanel panelDatosUsuario = getjPanelDatosProyecto();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, ventanaAnterior);

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getjPanelDatosProyecto() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(30, 15, 15, 10));

        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel panelLabels = new JPanel(new GridLayout(3, 1, 5, 5));
        panelLabels.add(crearLabels("Nombre Proy.: "));
        panelLabels.add(crearLabels("Tipo Proy.: "));
        panelLabels.add(crearLabels("Presupuest.: "));

        // Combos
        JComboBox<ProyectosENUM> comboBoxProyectos = new JComboBox<>(ProyectosENUM.values());
        JComboBox<PresupuestosENUM> comboBoxPresupuestos = new JComboBox<>(PresupuestosENUM.values());

        JPanel panelFields = new JPanel(new GridLayout(3, 1, 5, 5));

        txtNombre = crearFields();

        txtNombre.setText(proyecto.getNombre());

        // Tipo (enum)
        comboBoxProyectos.setSelectedItem(
                ProyectosENUM.fromNombreComercial(proyecto.getTipo())
        );

        // Presupuesto (enum)
        comboBoxPresupuestos.setSelectedItem(
                PresupuestosENUM.fromValor((int) proyecto.getPresupuesto())
        );

        JPanel panelBoton = new JPanel((new FlowLayout(FlowLayout.CENTER)));
        JButton btnModificarProyect = crearEstiloBotonSubmit("MODIFICAR PROYECTO");
        btnModificarProyect.setPreferredSize(new Dimension(380, 45));

        btnModificarProyect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nuevoNombre = txtNombre.getText();
                ProyectosENUM nuevoTipo = (ProyectosENUM) comboBoxProyectos.getSelectedItem();
                PresupuestosENUM nuevoPresupuesto = (PresupuestosENUM) comboBoxPresupuestos.getSelectedItem();

                proyecto.setNombre(nuevoNombre);
                proyecto.setTipo(nuevoTipo.toString());
                proyecto.setPresupuesto(nuevoPresupuesto.getRandom());

                // 1. Si el proyecto está finalizado, preguntar si quiere reactivarlo
                if (estaFinalizado(proyecto)) {

                    int respuesta = JOptionPane.showConfirmDialog(
                            null,
                            "⚠️ Este proyecto está finalizado.\n" +
                                    "¿Desea reactivarlo para modificarlo?",
                            "Proyecto finalizado",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (respuesta == JOptionPane.NO_OPTION) {
                        mostrarMensaje("❌ No se realizaron cambios");
                        return;
                    }

                    // 2. Reactivar el proyecto
                    proyecto.setFinalizado(false);
                    actualizarProyectoSiFinalizado(proyecto);

                    mostrarMensaje("✅ Proyecto reactivado y modificado correctamente");
                    new AsignarProgramador(proyecto).setVisible(true);
                    dispose();
                    return;
                }

                // 3. Si no está finalizado, modificar normalmente
                if (actualizarProyecto(proyecto)) {
                    mostrarMensaje("✅ Proyecto modificado correctamente");
                    new GestionProyectos().setVisible(true);
                    dispose();
                } else {
                    mostrarMensaje("❌ No se pudo modificar el proyecto");
                }
            }
        });


        panelBoton.add(btnModificarProyect);
        panelFields.add(txtNombre);
        panelFields.add(comboBoxProyectos);
        panelFields.add(comboBoxPresupuestos);

        panelCentro.add(panelLabels);
        panelCentro.add(panelFields);

        panelPrincipal.add(panelCentro, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;
    }

}
