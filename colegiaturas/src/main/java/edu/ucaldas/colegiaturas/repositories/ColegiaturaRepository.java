package edu.ucaldas.colegiaturas.repositories;

import edu.ucaldas.colegiaturas.entities.Colegiatura;
import edu.ucaldas.colegiaturas.entities.TipoPersona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColegiaturaRepository extends JpaRepository<Colegiatura, Long> {
    List<Colegiatura> findByTipoPersona(TipoPersona tipoPersona);
}
