package edu.ucaldas.colegiaturas.services;

import edu.ucaldas.colegiaturas.entities.Persona;
import edu.ucaldas.colegiaturas.repositories.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Optional<Persona> buscarPorCedula(String cedula) {
        return personaRepository.findByCedula(cedula);
    }

    public boolean estaHabilitada(String cedula) {
        return personaRepository.findByCedula(cedula)
                .map(Persona::isHabilitado)
                .orElse(false);
    }
}
