package mx.edu.utez.clinica.service;

import mx.edu.utez.clinica.ds.PriorityQueueSimple;
import mx.edu.utez.clinica.ds.StackDS;
import mx.edu.utez.clinica.model.Cita;
import mx.edu.utez.clinica.model.Prioridad;
import org.springframework.stereotype.Service;

@Service
public class CitaService {
    private final PriorityQueueSimple<Cita> queue = new PriorityQueueSimple<>();
    private final StackDS<Cita> historialAtenciones = new StackDS<>();
    private long nextId = 1;

    public Cita solicitarCita(Cita cita) {
        cita.setId(nextId++);
        queue.enqueue(cita, cita.getPrioridad() == null ? Prioridad.MEDIA : cita.getPrioridad());
        return cita;
    }

    public Cita atenderSiguiente() {
        Cita siguiente = queue.dequeue();
        if (siguiente != null) historialAtenciones.push(siguiente);
        return siguiente;
    }

    public boolean hayCitas() { return !queue.isEmpty(); }

    public Cita ultimoAtendido() { return historialAtenciones.peek(); }
}
