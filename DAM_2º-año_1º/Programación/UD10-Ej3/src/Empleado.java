public class Empleado {
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private int anosAntiguedad;
    private int telefContacto;
    private double salario;
    private Empleado supervisor;

    public Empleado(String nombre, String apellidos, String dni, String direccion, int anosAntiguedad, int telefContacto, double salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.anosAntiguedad = anosAntiguedad;
        this.telefContacto = telefContacto;
        this.salario = salario;
        this.supervisor = null;
    }

    public double incrementarSalario(double s) {
        return this.salario += this.salario * (s / 100);
    }
    public Empleado cambiarSupervisor(Empleado nuevoSupervisor){
        return this.supervisor = nuevoSupervisor;
    }

    public String imprimir(){
        return "Nombre: " + nombre + ", apellidos: " + apellidos + ", dni: " + dni +
                ", dirección: " + direccion + ", antigüedad: " + anosAntiguedad + ", teléfono: " + telefContacto + ", salario: " + salario;
    }

}
