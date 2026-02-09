public class Impuestos {

    private Impuestos() {
    }

    public static double calcularPVP(double precio, double impuesto) {
        if (impuesto < 0) {
            throw new IllegalArgumentException("El impuesto no puede ser negativo.");
        }
        return precio * (1 + impuesto);
    }

    public static double calcularPrecio(double pvp, double impuesto) {
        if (impuesto < 0) {
            throw new IllegalArgumentException("El impuesto no puede ser negativo.");
        }
        return pvp / (1 + impuesto);
    }
}
