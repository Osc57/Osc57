package Ap3;
import java.util.Map;

public class Ej1 {
    static void main() {
        Map<String, String> paisMap = Map.of("España", "Madrid", "Francia", "Paris", "Portugal", "Lisboa", "Noruega", "Oslo", "Alemania", "Berlín");


        for (Map.Entry<String, String> entrada : paisMap.entrySet()) {
            System.out.println("País: " + entrada.getKey() + " -> Capital: " + entrada.getValue());
        }
    }
}
