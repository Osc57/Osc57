import Humano.Cliente;
import Humano.Propietario;
import Maquina.Coche;
import Propiedad.Taller;

public class Main {
    public static void main(String[] args) throws Exception{
        Taller miTaller = new Taller();
        Propietario propietario;

        propietario = new Propietario("18444555A", "Pepe");
        propietario.setDireccion("CAsa del propietario");


        miTaller.setPropietario(propietario);
        miTaller.setDireccion("Calle del Taller");
        miTaller.setNombre("Taller del Mondrolo.");


        Coche coche = new Coche("1234AAA");

        Cliente cliente = new Cliente("18555666A","Juan");
        cliente.addVehiculo(coche);

        miTaller.addCliente(cliente);

        System.out.println(miTaller.toString());


    }
}