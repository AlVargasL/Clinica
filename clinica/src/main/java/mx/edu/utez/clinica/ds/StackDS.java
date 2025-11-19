package mx.edu.utez.clinica.ds;

import java.util.ArrayList;
import java.util.List;

public class StackDS<T> {
    private final List<T> elements = new ArrayList<>();

    public void push(T item) { elements.add(item); }
    public T pop() {
        if (elements.isEmpty()) return null;
        return elements.remove(elements.size() - 1);
    }
    public T peek() {
        if (elements.isEmpty()) return null;
        return elements.get(elements.size() - 1);
    }
    public boolean isEmpty() { return elements.isEmpty(); }
    public int size() { return elements.size(); }
}
