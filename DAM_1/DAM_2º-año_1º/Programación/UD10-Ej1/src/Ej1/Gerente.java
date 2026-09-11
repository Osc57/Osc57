package Ej1;

public class Gerente extends Empleado{
    private double bono;

    //Me genero los constructores de Gerente que extiende los atributos de la clase
    //padre Empleado
    public Gerente() {
    }
    public Gerente(String nombre, double salarioBase) {
        super(nombre, salarioBase);
    }
    public Gerente(String nombre, double salarioBase, double bono) {
        super(nombre, salarioBase);
        this.bono = bono;
    }

    //Sobreescribo el metodo de mostrarInfo
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() +", Bono: " + bono;
    }
}
