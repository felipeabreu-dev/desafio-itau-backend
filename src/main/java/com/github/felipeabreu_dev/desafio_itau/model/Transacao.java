package com.github.felipeabreu_dev.desafio_itau.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Transacao {

    private Double valor;
    private OffsetDateTime dataHora;

}
