package org.iesch;


import org.iesch.bbdd.DatabaseCRUD;
import org.iesch.modelos.Persona;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DatabaseCRUD bdcrud = new DatabaseCRUD();
        List<Persona> listPersonas = bdcrud.obtenerTodo();

        System.out.println(listPersonas);

    }
}
