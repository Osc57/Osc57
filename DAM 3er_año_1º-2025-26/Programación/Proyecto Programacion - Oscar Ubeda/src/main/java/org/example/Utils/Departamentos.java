package org.example.Utils;

public enum Departamentos {
    SELECCIONA("Selecciona un departamento..."),
    DIRECCION_PROYECTOS("Dirección de Proyectos"),
    DESARROLLO_SOFTWARE("Desarrollo de Software"),
    INGENIERIA_SISTEMAS("Ingeniería y Sistemas"),
    OPERACIONES_TECNICAS("Operaciones Técnicas"),
    ARQUITECTURA_SOLUCIONES("Arquitectura de Soluciones"),
    QA("Control de Calidad (QA)"),
    GESTION_PRODUCTO("Gestión de Producto"),
    INNOVACION_ID("Innovación y I+D"),
    INFRAESTRUCTURA_DEVOPS("Infraestructura y DevOps"),
    CONSULTORIA_TECNICA("Consultoría Técnica");

    private final String nombre;

    Departamentos(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
