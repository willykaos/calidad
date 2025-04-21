package edu.ucaldas.colegiaturas.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Colegiatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPersona tipoPersona;

    // Getters y Setters
}
