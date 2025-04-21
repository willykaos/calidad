package edu.ucaldas.colegiaturas.repositories;

import edu.ucaldas.colegiaturas.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByCedula(String cedula);
    boolean existsByCedula(String cedula);
}
