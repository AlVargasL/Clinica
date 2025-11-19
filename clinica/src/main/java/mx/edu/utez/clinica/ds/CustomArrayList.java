package mx.edu.utez.clinica.ds;

import java.util.Arrays;

public class CustomArrayList<T> {
    private Object[] data;
    private int size = 0;
    private static final int INITIAL = 10;

    public CustomArrayList() {
        data = new Object[INITIAL];
    }

    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }

    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                // desplazar a la izquierda
                for (int j = i; j < size - 1; j++) data[j] = data[j + 1];
                data[--size] = null;
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (T) data[index];
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    @SuppressWarnings("unchecked")
    public T[] toArray(T[] arr) {
        if (arr.length < size) {
            return (T[]) Arrays.copyOf(data, size, arr.getClass());
        }
        System.arraycopy(data, 0, arr, 0, size);
        if (arr.length > size) arr[size] = null;
        return arr;
    }

    private void ensureCapacity() {
        if (size == data.length) data = Arrays.copyOf(data, data.length * 2);
    }
}
