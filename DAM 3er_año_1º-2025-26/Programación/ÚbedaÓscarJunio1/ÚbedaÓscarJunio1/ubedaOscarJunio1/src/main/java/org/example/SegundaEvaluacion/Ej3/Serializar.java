package org.example.SegundaEvaluacion.Ej3;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;


public class Serializar {
    public static void main(String[] args) {

        ArrayList<Empleado> empleados = new ArrayList<>();

        Programador programador1 = new Programador("Antonio", 24, 1750.0, "Java");
        Programador programador2 = new Programador("Jose", 22, 1750.0, "Javascript");
        Programador programador3 = new Programador("Maria", 21, 1750.0, "Python");

        Diseñador diseñador1 = new Diseñador("Carlos", 32, 1800.0, "Bases de Datos");
        Diseñador diseñador2 = new Diseñador("Manuel", 20, 1750.0, "Webs");
        Diseñador diseñador3 = new Diseñador("Marina", 25, 1750.0, "Bases de Datos");

        empleados.add(programador1);
        empleados.add(programador2);
        empleados.add(programador3);

        empleados.add(diseñador1);
        empleados.add(diseñador2);
        empleados.add(diseñador3);

        ListaEmpleados listaEmpleados = new ListaEmpleados(empleados);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ListaEmpleados.class);
            //String jaxbFormattedOutput = Marshaller.JAXB_FORMATTED_OUTPUT;
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(listaEmpleados, new File("empleados1.dat"));

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
}
