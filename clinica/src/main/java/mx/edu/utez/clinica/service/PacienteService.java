package mx.edu.utez.clinica.service;

import mx.edu.utez.clinica.ds.CustomArrayList;
import mx.edu.utez.clinica.model.Paciente;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    private final CustomArrayList<Paciente> pacientes = new CustomArrayList<>();
    private long nextId = 1;

    public Paciente registerPaciente(Paciente p) {
        p.setId(nextId++);
        pacientes.add(p);
        return p;
    }

    public Paciente findById(long id) {
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente p = pacientes.get(i);
            if (p.getId() == id) return p;
        }
        return null;
    }

    public CustomArrayList<Paciente> getAll() { return pacientes; }

    public boolean remove(Paciente p) { return pacientes.remove(p); }
}
