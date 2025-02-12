public class Secretario extends Empleado{
    private boolean despacho;
    private int numFax;
    private double incrementa = 5;


    public Secretario(String nombre, String apellidos, String dni, String direccion, int telefContacto, double salario, boolean despacho, int numFax) {
        super(nombre, apellidos, dni, direccion, telefContacto, salario);
        this.despacho = despacho;
        this.numFax = numFax;
    }

    @Override
    public double incrementarSalario() {
        return salario = salario + salario * (incrementa/100);
    }

    @Override
    public String imprimir() {
        return super.imprimir() + ", despacho: " + despacho;
    }


}
