import java.util.Stack;

public class Pila {
    private Stack<Integer> pila = new Stack<Integer>();

    public Pila() {
    }

    public String push(int n) {
        if (n % 2 == 0 && n >= 40 && n <= 70) {
            pila.push(n);
            return "Número introducido correctamente";
        } else {
            throw new IllegalArgumentException("Error: El número debe ser multiplo de 2 y estar entre 40 y 70");
        }
    }

    public Integer pop() {
        if (!pila.isEmpty()) {
            return pila.pop();
        } else {
            throw new IllegalArgumentException("Error: La pila esta vacia no se puede hacer un pop");
        }
    }

    public boolean isEmpty() {
        return pila.isEmpty();
    }

    public Integer top() {
        if (!pila.isEmpty()) {
            return pila.peek();
        } else {
            throw new IllegalArgumentException("Error: La pila esta vacia");
        }
    }
}
