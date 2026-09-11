package org.example.Examen.Ej2;

import jakarta.xml.bind.annotation.XmlRootElement;
import org.example.Examen.Ej1.Registro;

import java.util.List;

@XmlRootElement
public class ListaRegistros {
    public List<Registro> registros;

    public ListaRegistros() {
    }

    public ListaRegistros(List<Registro> registros) {
        this.registros = registros;
    }
}
