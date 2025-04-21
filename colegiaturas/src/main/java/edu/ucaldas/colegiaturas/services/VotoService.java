package edu.ucaldas.colegiaturas.services;

import edu.ucaldas.colegiaturas.entities.Colegiatura;
import edu.ucaldas.colegiaturas.entities.Persona;
import edu.ucaldas.colegiaturas.entities.Voto;
import edu.ucaldas.colegiaturas.repositories.VotoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotoService {

    private final VotoRepository votoRepository;

    public VotoService(VotoRepository votoRepository) {
        this.votoRepository = votoRepository;
    }

    public boolean yaVoto(Persona persona) {
        return votoRepository.existsByPersona(persona);
    }

    public Optional<Voto> obtenerVoto(Persona persona) {
        return votoRepository.findByPersona(persona);
    }

    public Voto registrarVoto(Persona persona, Colegiatura colegiatura) {
        if (yaVoto(persona)) {
            throw new IllegalStateException("Esta persona ya votó.");
        }

        Voto voto = new Voto();
        voto.setPersona(persona);
        voto.setColegiatura(colegiatura);
        return votoRepository.save(voto);
    }
}
