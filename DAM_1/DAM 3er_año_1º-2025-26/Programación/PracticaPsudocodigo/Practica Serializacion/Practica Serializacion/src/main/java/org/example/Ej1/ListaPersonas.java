package org.example.Ej1;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class ListaPersonas {
    public List<Persona> personas;

    public ListaPersonas() {
    }

    public ListaPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}
