import java.util.ArrayList;

public class Vendedor extends Empleado{
    private String matricula;
    private String marca;
    private String modelo;
    private int telefono;
    private String areaVenta;
    private ArrayList<String> listaClientes;
    private double porcentaje;
    private double incremento = 10;

    public Vendedor(String nombre, String apellidos, String dni, String direccion, int telefContacto, double salario, String matricula, String marca, String modelo) {
        super(nombre, apellidos, dni, direccion, telefContacto, salario);
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public double incrementarSalario() {
        return salario = salario + salario * (incremento/100);
    }

    @Override
    public String imprimir() {
        return super.imprimir() + ", Puesto: vendedor" + ", Coche [Marticula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo + "]";
    }
}
