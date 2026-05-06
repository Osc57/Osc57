package org.example.Vista;

import org.example.Modelo.Departamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.ControladorDAO.DepartamentoDAO.*;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarError;

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

        JComboBox<String> comboBoxDepartamentos = new JComboBox<>(new String[]{
                "Selecciona un departamento...",
                "Dirección de Proyectos",
                "Desarrollo de Software",
                "Ingeniería y Sistemas",
                "Operaciones Técnicas",
                "Arquitectura de Soluciones",
                "Control de Calidad (QA)",
                "Gestión de Producto",
                "Innovación y I+D",
                "Infraestructura y DevOps",
                "Consultoría Técnica"
        });

        JComboBox<String> comboBoxUbicacion = new JComboBox<>();
        comboBoxUbicacion.addItem("Selecciona un piso...");

        for (int i = 1; i <= N_PISOS; i++) {
            comboBoxUbicacion.addItem("Piso " + i);
        }
        comboBoxDepartamentos.setSelectedIndex(0);
        comboBoxUbicacion.setSelectedIndex(0);

        JPanel panelBoton = new JPanel((new FlowLayout(FlowLayout.CENTER)));
        JButton btnCrearDpto = crearEstiloBotonSubmit("CREAR DEPARTAMENTO");
        btnCrearDpto.setPreferredSize(new Dimension(380, 45));

        btnCrearDpto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexDepartamento = comboBoxDepartamentos.getSelectedIndex();
                int indexUbicacion = comboBoxUbicacion.getSelectedIndex();


                if (indexDepartamento == 0) {
                    mostrarError("⚠️ Seleccione un departamento");
                    return;
                }

                if (indexUbicacion == 0) {
                    mostrarError("⚠️ Seleccione un piso");
                    return;
                }

                String departamento = comboBoxDepartamentos.getSelectedItem().toString();
                String ubicacion = comboBoxUbicacion.getSelectedItem().toString();

                Departamento dp = new Departamento(departamento, ubicacion);

                //Valido si el nombre es duplicado
                if (existeNombreDepartamento(dp)) {
                    mostrarError("⚠️ Ya existe un departamento registrado con el nombre " + dp.getNombre() + ".");
                    return;
                }

                //Mismo departamento en otro piso
                if (departamentoEnPiso(dp)) {
                    mostrarError("⚠️ La departamento " + dp.getNombre() + " ya está asignado en otro piso.");
                    return;
                }


                if (insertarDepartamento(dp)) {
                    mostrarError("✅ Departamento insertado correctamente");
                    dispose();
                    new GestionDepartamentos().setVisible(true);
                } else {
                    mostrarError("❌ Error al insertar el departamento");
                }

            }
        });

        panelFields.add(comboBoxDepartamentos);
        panelFields.add(comboBoxUbicacion);

        panelCentro.add(panelLabels);
        panelCentro.add(panelFields);

        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        panelBoton.add(btnCrearDpto);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);
        return panelPrincipal;
    }

    public static void main(String[] args) {
        new CrearDepartamento().setVisible(true);
    }
}
