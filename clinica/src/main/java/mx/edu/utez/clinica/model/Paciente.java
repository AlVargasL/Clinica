package mx.edu.utez.clinica.model;

public class Paciente {
    private Long id;
    private String nombre;
    private String apellidos;
    private int edad;
    private String telefono;

    public Paciente() {}
    public Paciente(Long id, String nombre, String apellidos, int edad, String telefono) {
        this.id = id; this.nombre = nombre; this.apellidos = apellidos; this.edad = edad; this.telefono = telefono;
    }

    // getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
