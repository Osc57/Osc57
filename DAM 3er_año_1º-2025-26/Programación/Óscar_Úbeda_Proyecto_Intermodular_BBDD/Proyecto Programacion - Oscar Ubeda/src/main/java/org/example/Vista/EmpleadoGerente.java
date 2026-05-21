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
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;
import static org.example.Utils.Validator.calcularBono;

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
        panelRegistro.setBorder(BorderFactory.createEmptyBorder(30, 15, 15, 10));

        // Panel central con los labels y los campos
        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JPanel panelLabels = new JPanel(new GridLayout(3, 1, 5, 5));
        panelLabels.add(crearLabels("Salario: "));
        panelLabels.add(crearLabels("Depto.: "));
        panelLabels.add(crearLabels("Nivel: "));

        JPanel panelFields = new JPanel(new GridLayout(3, 1, 5, 5));
        JTextField txtsalario = crearFields();

        JComboBox<Departamento> comboBoxDepart = new JComboBox<>();


        comboBoxDepart.addItem(new Departamento("Seleccione un departamento", " "));

        for (Departamento d : departamentos) {
            comboBoxDepart.addItem(d);
        }

        comboBoxDepart.setSelectedIndex(0);

        JComboBox<String> comboBoxNivel = new JComboBox<>(new String[]{
                "Selecciona nivel de gerente...", "Alto", "Medio", "Bajo"});

        comboBoxNivel.setSelectedIndex(0);

        panelFields.add(txtsalario);
        panelFields.add(comboBoxDepart);
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

                //Datos del empleado base
                String dni = empleado.getDni();
                String nombre = empleado.getNombre();
                String apellidos = empleado.getApellidos();
                String email = empleado.getEmail();
                String telefono = empleado.getTelefono();

                //Datos del formulario
                String salarioTexto = txtsalario.getText().trim();
                Departamento departamento = (Departamento) comboBoxDepart.getSelectedItem();
                int indexNivel = comboBoxNivel.getSelectedIndex();
                int indexDepartamento = comboBoxDepart.getSelectedIndex();
                Object nivelObj = comboBoxNivel.getSelectedItem();

                //Validaciones
                if (!Validator.salarioValido(salarioTexto)) {
                    mostrarMensaje("⚠️ El salario debe ser un número válido mayor que 0.");
                    return;
                }
                double salario = Double.parseDouble(salarioTexto.replace(",", "."));

                if (salario < MIN_MES || salario > MAX_MES) {
                    mostrarMensaje("⚠️ El salario mensual no es coherente.\n" +
                            "Rango permitido: " + MIN_MES + "€ - " + MAX_MES + "€");
                    return;
                }

                if (indexDepartamento == 0 || departamento == null) {
                    mostrarMensaje("⚠️ Debe seleccionar un departamento");
                    return;
                }

                if (indexNivel == 0 || nivelObj == null) {
                    mostrarMensaje("⚠️ Debes seleccionar un nivel.");
                    return;
                }


                // Conversión de datos
                int idDept = departamento.getId();
                String nivel = comboBoxNivel.getSelectedItem().toString();


                double bonoCalculado = calcularBono(nivel, salario);

                //Crear objetos
                Empleados empleadoCompleto = new Empleados(dni, nombre, apellidos, email, telefono, salario, idDept);

                //Inserciones en BD
                if (!insertarEmpleado(empleadoCompleto)) {
                    mostrarMensaje("❌ Error al insertar el empleado en la base de datos.");
                    return;
                }

                Gerente gerente = new Gerente(dni, bonoCalculado, nivel);

                if (!insertarGerente(empleadoCompleto, gerente)) {
                    mostrarMensaje("❌ Error al insertar los datos del gerente.");
                    return;
                }

                //Éxito
                mostrarMensaje("✅ Gerente dado de alta exitosamente");
                dispose();
                new GestionEmpleado().setVisible(true);
            }
        });


        panelRegistro.add(panelBoton, BorderLayout.SOUTH);

        return panelRegistro;
    }
}
