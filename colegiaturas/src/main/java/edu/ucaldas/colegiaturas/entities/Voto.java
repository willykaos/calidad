package edu.ucaldas.colegiaturas.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Persona persona;

    @ManyToOne(optional = false)
    private Colegiatura colegiatura;

    private LocalDateTime fechaVoto = LocalDateTime.now();

}

