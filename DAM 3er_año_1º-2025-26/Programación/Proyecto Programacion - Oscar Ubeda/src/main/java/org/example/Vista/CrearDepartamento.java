package org.example.Vista;

import org.example.Modelo.Departamento;
import org.example.Utils.DepartamentoENUM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.example.ControladorDAO.DepartamentoDAO.*;
import static org.example.ControladorDAO.EmpleadosDAO.saberSiNoHayEmpeladoEnDepartamento;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class CrearDepartamento extends JFrame {
    private JTextField txtNombre;

    public CrearDepartamento() {
        this.setTitle("Crear un departamento");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("Introduzca los datos del departamento");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 0));

        JPanel panelDatosUsuario = getjPanelDatosDepartamento();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new GestionDepartamentos());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    public JPanel getjPanelDatosDepartamento() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 10));

        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 30));

        JPanel panelLabels = new JPanel(new GridLayout(2, 1, 5, 5));
        panelLabels.add(crearLabels("Depto.: "));
        panelLabels.add(crearLabels("Ubicación: "));

        JPanel panelFields = new JPanel(new GridLayout(2, 1, 5, 5));

        ArrayList<Departamento> deptosOcupados = obtenerDepartamentos();

        DepartamentoENUM[] disponibles = Arrays.stream(DepartamentoENUM.values())
                .filter(depto ->
                        depto == DepartamentoENUM.SELECCIONA ||
                                // CAMBIO CLAVE: Usamos depto.toString() para comparar los textos legibles
                                deptosOcupados.stream().noneMatch(d -> d.getNombre().equalsIgnoreCase(depto.toString()))
                )
                .toArray(DepartamentoENUM[]::new);

        JComboBox<DepartamentoENUM> comboBoxDepartamentos = new JComboBox<>(disponibles);


        JComboBox<String> comboBoxUbicacion = new JComboBox<>();
        comboBoxUbicacion.addItem("Selecciona un piso...");

        for (int i = 1; i <= N_PISOS; i++) {
            comboBoxUbicacion.addItem("Piso " + i);
        }
        comboBoxDepartamentos.setSelectedIndex(0);
        comboBoxUbicacion.setSelectedIndex(0);

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton btnCrearYAsignarDepto = crearEstiloBotonSubmit("CREAR Y ASIGNAR DEPTO.");
        btnCrearYAsignarDepto.setPreferredSize(new Dimension(380, 45));

        btnCrearYAsignarDepto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepartamentoENUM deptoEnum = (DepartamentoENUM) comboBoxDepartamentos.getSelectedItem();
                int indexUbicacion = comboBoxUbicacion.getSelectedIndex();


                if (deptoEnum == DepartamentoENUM.SELECCIONA) {
                    mostrarMensaje("⚠️ Seleccione un departamento");
                    return;
                }

                if (indexUbicacion == 0) {
                    mostrarMensaje("⚠️ Seleccione un piso");
                    return;
                }

                String nombreDepto = deptoEnum.toString();
                String ubicacion = comboBoxUbicacion.getSelectedItem().toString();

                Departamento dp = new Departamento(nombreDepto, ubicacion);

                //Valido si el nombre es duplicado
                if (existeNombreDepartamento(dp)) {
                    mostrarMensaje("⚠️ Ya existe un departamento registrado con el nombre " + dp.getNombre() + ".");
                    return;
                }

                //Mismo departamento en otro piso
                if (departamentoEnPiso(dp)) {
                    mostrarMensaje("⚠️ La departamento " + dp.getNombre() + " ya está asignado en otro piso.");
                    return;
                }

                if (saberSiNoHayEmpeladoEnDepartamento()) {
                    if (insertarDepartamento(dp)) {
                        mostrarMensaje("✅ Departamento insertado correctamente");
                        new EmpleadosSinDepartamento().setVisible(true);
                        dispose();
                    } else {
                        mostrarMensaje("❌ Error al insertar el departamento");
                    }
                } else {
                    int respuesta = JOptionPane.showConfirmDialog(null, "⚠️ Los empelados estan asignados a departamentos \n" +
                                    "¿Quieres crear el departamento?", "Crear Departamento",
                            JOptionPane.YES_NO_OPTION);

                    if (respuesta == JOptionPane.YES_OPTION) {
                        if (insertarDepartamento(dp)) {
                            mostrarMensaje("✅ Departamento insertado correctamente");
                            new GestionDepartamentos().setVisible(true);
                            dispose();
                        } else {
                            mostrarMensaje("❌ Error al insertar el departamento");
                        }
                    }
                }

            }
        });

        panelFields.add(comboBoxDepartamentos);
        panelFields.add(comboBoxUbicacion);

        panelCentro.add(panelLabels);
        panelCentro.add(panelFields);

        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        panelBoton.add(btnCrearYAsignarDepto);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);
        return panelPrincipal;
    }

    public static void main(String[] args) {
        new CrearDepartamento().setVisible(true);
    }
}
