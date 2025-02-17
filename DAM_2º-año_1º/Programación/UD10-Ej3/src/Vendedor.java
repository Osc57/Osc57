import java.util.ArrayList;

public class Vendedor extends Empleado {
    private String matricula;
    private String marca;
    private String modelo;
    private int telefono;
    private String areaVenta;
    private ArrayList<String> listaClientes = new ArrayList<>();
    private double porcentaje;
    private double incremento = 10;

    public Vendedor(String nombre, String apellidos, String dni, String direccion, int telefContacto, double salario, String matricula, String marca, String modelo, int telefono, String areaVenta) {
        super(nombre, apellidos, dni, direccion, telefContacto, salario);
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.telefono = telefono;
        this.areaVenta = areaVenta;
    }

    @Override
    public double incrementarSalario() {
        return salario = salario + salario * (incremento / 100);
    }

    @Override
    public String imprimir() {
        return super.imprimir() + ", Puesto: vendedor" + ", Teléfono Móvil: " + telefono + ", Coche [Marticula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo + "], Area de Venta: " + areaVenta;
    }

    public String darDeAltaCliente(String cliente) {
        listaClientes.add(cliente);
        return "Cliente añadido";
    }

    public String darDeBajaCliente(String cliente) {
       if (listaClientes.isEmpty()){
           return "Lista Vacia";
       }else {
           listaClientes.remove(cliente);
           return "Cliente Borrado";
       }
    }

    public String cambiarDeCoche(String numberPlate, String marc, String model){
        if (numberPlate!=null && marc!=null && model!=null){
            matricula=numberPlate;
            marca=marc;
            modelo=model;
            return "";
        }else {
            return "Introduce datos validos";
        }
    }

}