package com.github.felipeabreu_dev.desafio_itau.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.OffsetDateTime;

public record TransacaoDTO(
        @NotNull
        Double valor,
        @Past
        @NotNull
        OffsetDateTime dataHora
) {}
