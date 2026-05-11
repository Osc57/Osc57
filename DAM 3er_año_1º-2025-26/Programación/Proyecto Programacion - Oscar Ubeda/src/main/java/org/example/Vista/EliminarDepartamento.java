package org.example.Vista;

import org.example.Modelo.Departamento;
import org.example.Modelo.Empleados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.ControladorDAO.DepartamentoDAO.*;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class EliminarDepartamento extends JFrame {

    public EliminarDepartamento() {
        this.setTitle("Eliminar Departamento");
        this.setSize(480, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•De de baja a un departamento");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelScrollPanel = getJPanelScrollPanel();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new GestionDepartamentos());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelScrollPanel, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    public JPanel getJPanelScrollPanel() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));

        configurarListaEnScroll(LISTA_DEPTO);

        JScrollPane jScrollPane = new JScrollPane(LISTA_DEPTO);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 5));

        MODEL_DEPTO.removeAllElements();

        ArrayList<Departamento> empleados = obtenerDepartamentos();
        for (Departamento d : empleados) {
            MODEL_DEPTO.addElement(d);
        }

        JButton btnSeleccionEmple = crearEstiloBotonSubmit("SELECCIONAR DEPARTAMENTO");
        btnSeleccionEmple.setPreferredSize(new Dimension(420, 45));

        btnSeleccionEmple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Departamento seleccionado = LISTA_DEPTO.getSelectedValue();

                if (seleccionado == null) {
                    mostrarMensaje("⚠️ Seleccione una opción");
                    return;
                }

                if (seleccionarDepartamento(seleccionado)) {
                    int respuesta1 = JOptionPane.showConfirmDialog(null, "⚠️ ¿Esta seguro de que quiere eliminar este Departamento?", "Eliminar Departamento",
                            JOptionPane.YES_NO_OPTION);
                    if (respuesta1 == JOptionPane.YES_OPTION) {
                        if (contarEmpleadosDepartamento(seleccionado)) {
                            int respuesta2 = JOptionPane.showConfirmDialog(null, "⚠️ Hay empleados asignados al departamento \n" +
                                            "Tendras que modificar los datos después", "Eliminar Departamento",
                                    JOptionPane.YES_NO_OPTION);
                            if (respuesta2 == JOptionPane.YES_OPTION) {
                                if (eliminarDepartamentos(seleccionado)) {
                                    mostrarMensaje("✅ Departamento eliminado correctamente");
                                    dispose();
                                    new GestionDepartamentos().setVisible(true);
                                } else {
                                    mostrarMensaje("❌ Error al eliminar el departamento");
                                }
                            }
                        } else {
                            int respuesta2 = JOptionPane.showConfirmDialog(null, "⚠️ No hay empleados asignados al departamento \n" +
                                            "¿Quieres darlo de baja?", "Eliminar Departamento",
                                    JOptionPane.YES_NO_OPTION);
                            if (respuesta2 == JOptionPane.YES_OPTION) {
                                if (eliminarDepartamentos(seleccionado)) {
                                    mostrarMensaje("✅ Departamento eliminado correctamente");
                                    dispose();
                                    new GestionDepartamentos().setVisible(true);
                                } else {
                                    mostrarMensaje("❌ Error al eliminar el departamento");
                                }
                            }

                        }

                    }
                }
            }
        });
        panelBoton.add(btnSeleccionEmple);

        panelPrincipal.add(jScrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;
    }
}



