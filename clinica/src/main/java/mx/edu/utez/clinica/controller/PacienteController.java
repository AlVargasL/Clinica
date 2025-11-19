package mx.edu.utez.clinica.controller;

import mx.edu.utez.clinica.model.Paciente;
import mx.edu.utez.clinica.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;
    public PacienteController(PacienteService ps) { this.pacienteService = ps; }

    @PostMapping("/registro")
    public ResponseEntity<Paciente> registrar(@RequestBody Paciente p) {
        return ResponseEntity.ok(pacienteService.registerPaciente(p));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable long id) {
        Paciente p = pacienteService.findById(id);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    @GetMapping
    public ResponseEntity<?> listar() { return ResponseEntity.ok(pacienteService.getAll()); }
}
