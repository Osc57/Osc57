public class Demo {
    public static void main(String[] args) {
        Empleado secretario = new Secretario("Agustin","Perez","11111111R","C/Direccion",977777777,1500, true, 78421888);

        System.out.println(secretario.imprimir());
        System.out.println(secretario.incrementarSalario());
        System.out.println(secretario.imprimir());

    }
}
