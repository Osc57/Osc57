package org.iesch;


import org.iesch.bbdd.DatabaseCRUD;
import org.iesch.modelos.Persona;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DatabaseCRUD bdcrud = new DatabaseCRUD();

        //READ
        List<Persona> listPersonas = bdcrud.obtenerTodo();
        System.out.println(listPersonas);

        //INSERT
        Persona persona = new Persona("18446777A","Antonio","Lopez","poco",180,70.5F);
        bdcrud.inserta(persona);

    }
}
