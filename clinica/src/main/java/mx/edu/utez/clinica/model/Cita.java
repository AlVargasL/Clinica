package mx.edu.utez.clinica.model;

public class Cita {
    private Long id;
    private Paciente paciente;
    private String motivo;
    private Prioridad prioridad;

    public Cita() {}
    public Cita(Long id, Paciente paciente, String motivo, Prioridad prioridad){
        this.id = id; this.paciente = paciente; this.motivo = motivo; this.prioridad = prioridad;
    }

    // getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public Prioridad getPrioridad() { return prioridad; }
    public void setPrioridad(Prioridad prioridad) { this.prioridad = prioridad; }
}
