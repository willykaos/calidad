package edu.ucaldas.colegiaturas.Controller;

import edu.ucaldas.colegiaturas.dto.ResultadoDTO;
import edu.ucaldas.colegiaturas.entities.Colegiatura;
import edu.ucaldas.colegiaturas.repositories.ColegiaturaRepository;
import edu.ucaldas.colegiaturas.repositories.VotoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/resultados")
@CrossOrigin(origins = "*")
public class ResultadoController {

    private final VotoRepository votoRepository;
    private final ColegiaturaRepository colegiaturaRepository;

    public ResultadoController(VotoRepository votoRepository, ColegiaturaRepository colegiaturaRepository) {
        this.votoRepository = votoRepository;
        this.colegiaturaRepository = colegiaturaRepository;
    }

    @GetMapping
    public List<ResultadoDTO> obtenerResultados() {
        List<Colegiatura> colegiaturas = colegiaturaRepository.findAll();

        Map<String, Long> votosTotales = colegiaturas.stream().collect(Collectors.toMap(
                Colegiatura::getNombre,
                c -> votoRepository.findAll().stream()
                        .filter(v -> v.getColegiatura().getId().equals(c.getId()))
                        .count()
        ));

        List<ResultadoDTO> resultado = new ArrayList<>();
        for(Map.Entry<String, Long> map : votosTotales.entrySet()){
            resultado.add( new ResultadoDTO(map.getKey(), map.getValue()));
        }
        return resultado;
    }

}
