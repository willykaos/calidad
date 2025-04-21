package edu.ucaldas.colegiaturas.Controller;

import edu.ucaldas.colegiaturas.entities.Colegiatura;
import edu.ucaldas.colegiaturas.entities.Persona;
import edu.ucaldas.colegiaturas.entities.Voto;
import edu.ucaldas.colegiaturas.services.ColegiaturaService;
import edu.ucaldas.colegiaturas.services.PersonaService;
import edu.ucaldas.colegiaturas.services.VotoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/voto")
@CrossOrigin(origins = "*")
public class VotoController {

    private final VotoService votoService;
    private final PersonaService personaService;
    private final ColegiaturaService colegiaturaService;

    public VotoController(VotoService votoService, PersonaService personaService, ColegiaturaService colegiaturaService) {
        this.votoService = votoService;
        this.personaService = personaService;
        this.colegiaturaService = colegiaturaService;
    }

    @PostMapping
    public Voto votar(@RequestParam String cedula, @RequestParam Long colegiaturaId) {
        Persona persona = personaService.buscarPorCedula(cedula)
                .orElseThrow(() -> new RuntimeException("Cédula no registrada."));

        if (votoService.yaVoto(persona)) {
            throw new IllegalStateException("Ya se registró un voto con esta cédula.");
        }

        Colegiatura colegiatura = colegiaturaService.listarPorTipoPersona(persona.getTipoPersona()).stream()
                .filter(c -> c.getId().equals(colegiaturaId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No puede votar en esta colegiatura."));

        return votoService.registrarVoto(persona, colegiatura);
    }
}
