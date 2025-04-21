package edu.ucaldas.colegiaturas.Controller;

import edu.ucaldas.colegiaturas.entities.Colegiatura;
import edu.ucaldas.colegiaturas.entities.Persona;
import edu.ucaldas.colegiaturas.services.ColegiaturaService;
import edu.ucaldas.colegiaturas.services.PersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votante")
@CrossOrigin(origins = "*") // para permitir peticiones desde el frontend
public class VotanteController {

    private final PersonaService personaService;
    private final ColegiaturaService colegiaturaService;


    public VotanteController(PersonaService personaService,
                             ColegiaturaService colegiaturaService) {
        this.personaService = personaService;
        this.colegiaturaService = colegiaturaService;

    }

    @GetMapping("/{cedula}")
    public List<Colegiatura> obtenerColegiaturasHabilitadas(@PathVariable String cedula) {
        Persona persona = personaService.buscarPorCedula(cedula)
                .orElseThrow(() -> new RuntimeException("Cédula no registrada."));

        if (!persona.isHabilitado()) {
            throw new IllegalArgumentException("Persona no habilitada internamente.");
        }

        return colegiaturaService.listarPorTipoPersona(persona.getTipoPersona());
    }
}
