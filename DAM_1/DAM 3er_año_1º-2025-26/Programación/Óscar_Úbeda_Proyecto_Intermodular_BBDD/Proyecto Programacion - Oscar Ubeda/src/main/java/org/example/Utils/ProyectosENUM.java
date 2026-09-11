package org.example.Utils;

public enum ProyectosENUM {

    SELECCIONE_PROYECTO("Seleccione Proyecto..."),
    DESARROLLO_WEB("Desarrollo Web"),
    APLICACIONES_MOVILES("Aplicaciones Móviles"),
    SOFTWARE_A_MEDIDA("Software a Medida (SaaS)"),
    E_COMMERCE("Tienda Online / E-commerce"),
    ERP_CRM("Implantación ERP / CRM"),
    AUTOMATIZACION_RPA("Automatización (RPA)"),
    MIGRACION_NUBE("Migración a la Nube"),
    CIBERSEGURIDAD("Auditoría de Ciberseguridad"),
    BUSINESS_INTELLIGENCE("Business Intelligence"),
    INTELIGENCIA_ARTIFICIAL("Inteligencia Artificial"),
    MVP_STARTUP("Producto Mínimo Viable (MVP)");

    private final String nombreComercial;

    ProyectosENUM(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    @Override
    public String toString() {
        return nombreComercial;
    }

    public static ProyectosENUM fromNombreComercial(String texto) {
        for (ProyectosENUM p : values()) {
            if (p.nombreComercial.equalsIgnoreCase(texto)) {
                return p;
            }
        }
        throw new IllegalArgumentException("No enum constant for: " + texto);
    }
}

