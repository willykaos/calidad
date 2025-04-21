package edu.ucaldas.colegiaturas.repositories;

import edu.ucaldas.colegiaturas.entities.Persona;
import edu.ucaldas.colegiaturas.entities.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VotoRepository extends JpaRepository<Voto, Long> {
    Optional<Voto> findByPersona(Persona persona);
    boolean existsByPersona(Persona persona);
}
