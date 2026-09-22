package Ejercicios_Streams.Ej5;


/*
Crea la clase empleado con al menos los atributos: nombre, departamento.
- Crea varios empleados y agrupar la lista de empleados por departamento.
- Agrupamos los empleados por departamento y contamos cuantos empleados hay en
cada departamento.
- Dado un departamento mostraremos sus empleados. Por ejemplo, muestra los
empleados de ventas.
- Dado un nombre de empleado, mostraremos su departamento.
*/

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ej5 {
    static void main() {
        List<Empleado> empleados = List.of(
                new Empleado("Manuel", "Atencion al cliente"),
                new Empleado("Alejandro", "Contabilidad"),
                new Empleado("Maria", "Contabilidad"),
                new Empleado("Alfonso", "Asuntos internos"),
                new Empleado("Rejina", "Atencion al cliente")
        );

        Map<String, List<Empleado>> empleadosPorDepartamento = empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento));
        
        System.out.println("-------------- Empleados por departamento --------------");
        System.out.println(empleadosPorDepartamento);


        Map<String, Long> conteoPorDepartamento = empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento, Collectors.counting()));

        System.out.println("-------------- Empleados por departamento y cantidad --------------");
        conteoPorDepartamento.forEach((departamento, cantidad) ->
                System.out.println(departamento + ": " + cantidad));
    }
}
