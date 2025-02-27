package org.example;

import java.util.Stack;

public class Pila {
    private Stack<Integer> pilaStack;

    public Pila() {
        this.pilaStack = new Stack<>();
    }

    public boolean push(int n) {
        if (n % 2 == 0 && n >= 40 && n <= 70) {
            pilaStack.push(n);
            return true;
        }
        return false;
    }

    public Integer pop() {
        if (!pilaStack.isEmpty()) {
            return pilaStack.pop();
        }
        return null;
    }

    public boolean isEmpty() {
        return pilaStack.isEmpty();
    }

    public Integer top() {
        if (!pilaStack.isEmpty()) {
            return pilaStack.peek();
        }
        return null;
    }

    public int size() {
        return pilaStack.size();
    }
}


