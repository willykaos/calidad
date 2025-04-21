package edu.ucaldas.colegiaturas.dto;

import lombok.Data;

@Data
public class ResultadoDTO {

    public ResultadoDTO(String nombreColegiatura, Long totalVotos) {
        this.nombreColegiatura = nombreColegiatura;
        this.totalVotos = totalVotos;
    }

    private String nombreColegiatura;

    private Long totalVotos;
}
