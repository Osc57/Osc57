package org.example.Vista;

import org.example.Modelo.Departamento;
import org.example.Modelo.Empleados;
import org.example.Modelo.Programador;
import org.example.Utils.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.ControladorDAO.DepartamentoDAO.obtenerDepartamentos;
import static org.example.ControladorDAO.EmpleadosDAO.insertarEmpleado;
import static org.example.ControladorDAO.ProgramadorDAO.insertarProgramador;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarError;

public class EmpleadoProgramador extends JFrame {
    private DarAltaEmpleado ventanaAnterior;
    private Empleados empleado;
    private ArrayList<Departamento> departamentos = obtenerDepartamentos();

    private final double MIN_PROG = 1600.0;
    private final double MAX_PROG = 7000.0;

    public EmpleadoProgramador(DarAltaEmpleado ventanaAnterior, Empleados empleado) {
        this.ventanaAnterior = ventanaAnterior;
        this.empleado = empleado;

        this.setTitle("Programador");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("Introduzca los datos del programador");
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

        JPanel panelLabels = new JPanel(new GridLayout(3, 1, 5, 5));
        panelLabels.add(crearLabels("Salario: "));
        panelLabels.add(crearLabels("Depto.: "));
        panelLabels.add(crearLabels("Leng. Pro.: "));//Combo Box

        JPanel panelFields = new JPanel(new GridLayout(3, 1, 5, 5));
        JTextField txtsalario = crearFields();

        JComboBox<Departamento> comboBoxDepart = new JComboBox<>();
        comboBoxDepart.addItem(new Departamento("Seleccione un departamento..."));

        for (Departamento d : departamentos) {
            comboBoxDepart.addItem(d);
        }

        comboBoxDepart.setSelectedIndex(0);

        JComboBox<String> comboBoxLProgramacion = new JComboBox<>(new String[]{
                "Seleccione un lenguaje...", "JavaScript", "Python", "Java", "C#", "Otro..."
        });

        comboBoxLProgramacion.setSelectedIndex(0);

        panelFields.add(txtsalario);
        panelFields.add(comboBoxDepart);
        panelFields.add(comboBoxLProgramacion);

        panelCentro.add(panelLabels);
        panelCentro.add(panelFields);
        panelRegistro.add(panelCentro, BorderLayout.CENTER);


        JPanel panelBoton = new JPanel((new FlowLayout(FlowLayout.CENTER)));
        JButton btnCrearUser = crearEstiloBotonSubmit("DAR DE ALTA PROGRAMADOR");
        btnCrearUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Datos empleado
                String dni = empleado.getDni();
                String nombre = empleado.getNombre();
                String apellidos = empleado.getApellidos();
                String email = empleado.getEmail();
                String telefono = empleado.getTelefono();

                //Datos Programador
                String salarioTexto = txtsalario.getText().trim();
                Departamento departamento = (Departamento) comboBoxDepart.getSelectedItem();
                int indexLenguaje = comboBoxLProgramacion.getSelectedIndex();
                int indexDepartamento = comboBoxDepart.getSelectedIndex();

                //Validaciones
                if (!Validator.salarioValido(salarioTexto)) {
                    mostrarError("⚠️ El salario debe ser un número válido mayor que 0.");
                    return;
                }

                double salario = Double.parseDouble(salarioTexto.replace(",", "."));
                if (salario < MIN_PROG) {
                    mostrarError("⚠️ El salario es demasiado bajo para un programador (Mín: " + MIN_PROG + "€)");
                    return;
                }

                if (salario > MAX_PROG) {
                    mostrarError("⚠️ El salario excede el rango técnico. Si cobra más de " + MAX_PROG + "€, quizás deba ser dado de alta como Gerente.");
                    return;
                }

                if (indexDepartamento == 0) {
                    mostrarError("⚠️ Debe seleccionar un departamento");
                    return;
                }

                if (indexLenguaje == 0) {
                    mostrarError("⚠️ Debes seleccionar un lenguaje de programación.");
                    return;
                }

                // Conversión de datos
                int idDept = departamento.getId();
                String lenguajeProgramacionString = comboBoxLProgramacion.getSelectedItem().toString();


                //Crear objetos
                Empleados empleadoCompleto = new Empleados(dni, nombre, apellidos, email, telefono, salario, idDept);

                //Inserciones en BD
                if (!insertarEmpleado(empleadoCompleto)) {
                    mostrarError("❌ Error al insertar el empleado en la base de datos.");
                    return;
                }

                Programador programador = new Programador(lenguajeProgramacionString);

                if (!insertarProgramador(empleadoCompleto, programador)) {
                    mostrarError("❌ Error al insertar los datos del programador.");
                    return;
                }

                //Éxito
                mostrarError("✅ Programador dado de alta exitosamente");
                dispose();
                new GestionEmpleado().setVisible(true);

            }
        });

        btnCrearUser.setPreferredSize(new Dimension(380, 45));
        panelBoton.add(btnCrearUser);

        panelRegistro.add(panelBoton, BorderLayout.SOUTH);

        return panelRegistro;
    }
}
