package com.github.felipeabreu_dev.desafio_itau.controller;

import com.github.felipeabreu_dev.desafio_itau.dto.EstatisticaDTO;
import com.github.felipeabreu_dev.desafio_itau.model.Estatistica;
import com.github.felipeabreu_dev.desafio_itau.service.EstatisticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    @GetMapping
    public ResponseEntity<EstatisticaDTO> obterEstatisticas() {
        EstatisticaDTO estatistica = estatisticaService.obterEstatisticas();

        return ResponseEntity.status(HttpStatus.OK).body(estatistica);
    }

}
