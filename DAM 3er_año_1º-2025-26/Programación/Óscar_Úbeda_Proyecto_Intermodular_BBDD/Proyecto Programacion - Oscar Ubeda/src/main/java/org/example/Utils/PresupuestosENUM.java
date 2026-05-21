package org.example.Utils;

public enum PresupuestosENUM {
    SELECCIONE_PRESUPUESTO("Seleccione Presupuesto...", 0, 0),
    BAJO_MVP("5.000€ - 15.000€ (MVP / Básico)", 5000, 15000),
    MEDIO_ESTANDAR("15.000€ - 40.000€ (Media del Mercado)", 15000, 40000),
    AVANZADO_ENTERPRISE("40.000€ - 100.000€ (Avanzado)", 40000, 100000),
    GRAN_ESCALA("Más de 100.000€ (Corporativo)", 100000, 999999);

    private final String rangoTexto;
    private final int min;
    private final int max;

    PresupuestosENUM(String rangoTexto, int min, int max) {
        this.rangoTexto = rangoTexto;
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        return rangoTexto;
    }

    public int getRandom() {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public static PresupuestosENUM fromValor(int valor) {
        for (PresupuestosENUM p : values()) {
            if (valor >= p.min && valor <= p.max) {
                return p;
            }
        }
        throw new IllegalArgumentException("No enum constant for value: " + valor);
    }
}

