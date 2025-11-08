package com.github.felipeabreu_dev.desafio_itau.model;

import lombok.Data;

@Data
public class Estatistica {

    private Integer count = 0;
    private Double sum = 0.0;
    private Double avg = 0.0;
    private Double min = 0.0;
    private Double max = 0.0;

}
