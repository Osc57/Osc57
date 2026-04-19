package org.example.Vista;

import org.example.Modelo.Departamento;
import org.example.Modelo.Empleados;
import org.example.Modelo.Gerente;
import org.example.Utils.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.ControladorDAO.DepartamentoDAO.obtenerDepartamentos;
import static org.example.ControladorDAO.EmpleadosDAO.insertarEmpleado;
import static org.example.ControladorDAO.GerenteDAO.insertarGerente;
import static org.example.Utils.Estilos.*;
import static org.example.Utils.Messages.mostrarError;

public class EmpleadoGerente extends JFrame {

    private DarAltaEmpleado ventanaAnterior;
    private Empleados empleado;
    private ArrayList<Departamento> departamentos = obtenerDepartamentos();

    public EmpleadoGerente(DarAltaEmpleado ventanaAnterior, Empleados empleado) {
        this.ventanaAnterior = ventanaAnterior;
        this.empleado = empleado;

        this.setTitle("Gerente");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("Introduzca los datos del gerente");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 50, 0, 0));

        JPanel panelDatosUsuario = getjPanelDatosUsuario();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, ventanaAnterior);

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getjPanelDatosUsuario() {
        JPanel panelRegistro = new JPanel(new BorderLayout());
        panelRegistro.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 10));

        // Panel central con los labels y los campos
        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JPanel panelLabels = new JPanel(new GridLayout(4, 1, 5, 5));
        panelLabels.add(crearLabels("Salario: "));
        panelLabels.add(crearLabels("Depto.: "));
        panelLabels.add(crearLabels("Bono: "));
        panelLabels.add(crearLabels("Nivel: "));

        JPanel panelFields = new JPanel(new GridLayout(4, 1, 5, 5));
        JTextField txtsalario = crearFields();

        JComboBox<Departamento> comboBoxDepart = new JComboBox<>();

        for (Departamento d : departamentos) {
            comboBoxDepart.addItem(d);
        }

        JTextField txtbono = crearFields();

        JComboBox<String> comboBoxNivel = new JComboBox<>(new String[]{"Alto", "Medio", "Bajo"});

        panelFields.add(txtsalario);
        panelFields.add(comboBoxDepart);
        panelFields.add(txtbono);
        panelFields.add(comboBoxNivel);


        panelCentro.add(panelLabels);
        panelCentro.add(panelFields);
        panelRegistro.add(panelCentro, BorderLayout.CENTER);

        // Panel del botón centrado abajo
        JPanel panelBoton = new JPanel((new FlowLayout(FlowLayout.CENTER)));
        JButton btnCrearUser = crearEstiloBotonSubmit("DAR DE ALTA GERENTE");

        btnCrearUser.setPreferredSize(new Dimension(380, 45));
        panelBoton.add(btnCrearUser);

        btnCrearUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = empleado.getDni();
                String nombre = empleado.getNombre();
                String apellidos = empleado.getApellidos();
                String email = empleado.getEmail();
                String telefono = empleado.getTelefono();

                String salarioTexto = txtsalario.getText().trim();
                Departamento departamento = (Departamento) comboBoxDepart.getSelectedItem();

                String bonoTexto = txtbono.getText().trim();

                if (!Validator.salarioValido(salarioTexto)) {
                    mostrarError("⚠️ El salario debe ser un número válido mayor que 0.");
                    return;
                }

                if (departamento == null) {
                    mostrarError("⚠️ Debes seleccionar un departamento.");
                    return;
                }
                int idDept = departamento.getId();

                if (!Validator.bonoValido(bonoTexto)) {
                    mostrarError("⚠️ El bono debe ser un número válido mayor que 0.");
                    return;
                }

                Object nivelObj = comboBoxNivel.getSelectedItem();
                if (nivelObj == null) {
                    mostrarError("⚠️ Debes seleccionar un nivel.");
                    return;
                }

                String nivel = comboBoxNivel.getSelectedItem().toString();

                double salario = Double.parseDouble(salarioTexto.replace(",", "."));
                double bono = Double.parseDouble(bonoTexto.replace(",", "."));

                Empleados empleadoCompleto = new Empleados(dni, nombre, apellidos, email, telefono, salario, idDept);
                
                if (insertarEmpleado(empleadoCompleto)) {
                    Gerente gerente = new Gerente(dni, bono, nivel);
                    if (insertarGerente(empleadoCompleto, gerente)) {
                        mostrarError("✅ Gerente dado de alta exitosamente");
                        dispose();
                        new GestionEmpleado().setVisible(true);
                    } else {
                        mostrarError("❌ Error al insertar los datos del gerente.");
                    }
                } else {
                    mostrarError("❌ Error al insertar el empleado en la base de datos.");
                }


            }
        });

        panelRegistro.add(panelBoton, BorderLayout.SOUTH);

        return panelRegistro;
    }

}
