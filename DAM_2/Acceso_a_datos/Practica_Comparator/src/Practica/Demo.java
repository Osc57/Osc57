package Practica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.PriorityQueue;

public class Demo {
    static void main() {
        PriorityQueue<Paciente> cola = new PriorityQueue<>(new ComparadorGravedad());

        try {
            List<Paciente> pacientes = Files.lines(Paths.get("pacientes.txt"))
                    .map(linea -> linea.replace("gravedad ", ""))
                    .map(lineaLimpia -> {
                        String[] partes = lineaLimpia.trim().split("\\s*—\\s*");
                        return new String[]{"", partes[0], partes[1], partes[2]};
                    })
                    .map(Paciente::new)
                    .toList();
            
            cola.addAll(pacientes);

            while (!cola.isEmpty()) {
                Paciente siguientePaciente = cola.poll();
                System.out.println(siguientePaciente);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
