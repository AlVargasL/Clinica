package mx.edu.utez.clinica.ds;

import mx.edu.utez.clinica.model.Prioridad;

public class PriorityQueueSimple<T> {
    private final QueueDS<T> alta = new QueueDS<>();
    private final QueueDS<T> media = new QueueDS<>();
    private final QueueDS<T> baja = new QueueDS<>();

    public void enqueue(T item, Prioridad prioridad) {
        switch (prioridad) {
            case ALTA -> alta.enqueue(item);
            case MEDIA -> media.enqueue(item);
            case BAJA -> baja.enqueue(item);
        }
    }

    public T dequeue() {
        if (!alta.isEmpty()) return alta.dequeue();
        if (!media.isEmpty()) return media.dequeue();
        return baja.dequeue();
    }

    public boolean isEmpty() {
        return alta.isEmpty() && media.isEmpty() && baja.isEmpty();
    }
}
