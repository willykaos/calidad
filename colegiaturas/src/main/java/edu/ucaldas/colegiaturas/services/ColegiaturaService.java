package edu.ucaldas.colegiaturas.services;

import edu.ucaldas.colegiaturas.entities.Colegiatura;
import edu.ucaldas.colegiaturas.entities.TipoPersona;
import edu.ucaldas.colegiaturas.repositories.ColegiaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColegiaturaService {

    private final ColegiaturaRepository colegiaturaRepository;

    public ColegiaturaService(ColegiaturaRepository colegiaturaRepository) {
        this.colegiaturaRepository = colegiaturaRepository;
    }

    public List<Colegiatura> listarPorTipoPersona(TipoPersona tipoPersona) {
        return colegiaturaRepository.findByTipoPersona(tipoPersona);
    }
}
