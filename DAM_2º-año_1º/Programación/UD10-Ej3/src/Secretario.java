public class Secretario extends Empleado{
    private boolean despacho;
    private int numFax;
    private double incrementa = 0.05;


    public Secretario(String nombre, String apellidos, String dni, String direccion, int telefContacto, double salario, boolean despacho, int numFax, double incrementa) {
        super(nombre, apellidos, dni, direccion, telefContacto, salario);
        this.despacho = despacho;
        this.numFax = numFax;
        this.incrementa = incrementa;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + ", despacho: " + despacho;
    }
    

}
