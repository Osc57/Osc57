import java.util.Stack;

public class Pila {
    private Stack<Integer> pila = new Stack<Integer>();
    
    public boolean push(int n) {
        if (n % 2 == 0 && n >= 40 && n <= 70) {
            pila.push(n);
            return true;
        } else {
            return false;
        }
    }

    public Integer pop() {
        if (!pila.isEmpty()) {
            return pila.pop();
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return pila.isEmpty();
    }

    public Integer top() {
        if (!pila.isEmpty()) {
            return pila.peek();
        } else {
            return null;
        }
    }

    public  int size(){
        return pila.size();
    }
}
