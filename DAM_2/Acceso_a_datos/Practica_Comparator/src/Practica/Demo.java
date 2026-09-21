package Practica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Demo {
    static void main() {
        try {
            List<Paciente> pacientes = Files.lines(Paths.get("pacientes.txt"))
                    .map(linea -> linea.replace("gravedad ", ""))
                    .map(lineaLimpia -> {
                        String[] partes = lineaLimpia.trim().split("\\s*—\\s*");
                        return new String[]{"", partes[0], partes[1], partes[2]};
                    })
                    .map(Paciente::new)
                    .sorted(Paciente.comparadorGravedad())
                    .toList();

            pacientes.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
