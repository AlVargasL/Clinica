package mx.edu.utez.clinica.controller;

import mx.edu.utez.clinica.model.Cita;
import mx.edu.utez.clinica.service.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
    private final CitaService citaService;
    public CitaController(CitaService cs) { this.citaService = cs; }

    @PostMapping("/solicitar")
    public ResponseEntity<Cita> solicitar(@RequestBody Cita c) {
        return ResponseEntity.ok(citaService.solicitarCita(c));
    }

    @PostMapping("/atender")
    public ResponseEntity<?> atender() {
        Cita atendida = citaService.atenderSiguiente();
        if (atendida == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(atendida);
    }

    @GetMapping("/ultimo")
    public ResponseEntity<?> ultimoAtendido() {
        return ResponseEntity.ok(citaService.ultimoAtendido());
    }
}
