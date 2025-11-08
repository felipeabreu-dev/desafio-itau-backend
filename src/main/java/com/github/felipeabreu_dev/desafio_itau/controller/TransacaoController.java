package com.github.felipeabreu_dev.desafio_itau.controller;

import com.github.felipeabreu_dev.desafio_itau.dto.TransacaoDTO;
import com.github.felipeabreu_dev.desafio_itau.service.TransacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {

    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Void> salvarTransacao(@RequestBody TransacaoDTO dto) {

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
