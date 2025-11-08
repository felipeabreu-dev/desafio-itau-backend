package com.github.felipeabreu_dev.desafio_itau.mapper;

import com.github.felipeabreu_dev.desafio_itau.dto.EstatisticaDTO;
import com.github.felipeabreu_dev.desafio_itau.model.Estatistica;
import org.springframework.stereotype.Component;

@Component
public class EstatisticaMapper {

  public EstatisticaDTO paraDTO(Estatistica estatistica) {
    EstatisticaDTO dto = new EstatisticaDTO(
            estatistica.getCount(),
            estatistica.getSum(),
            estatistica.getAvg(),
            estatistica.getMin(),
            estatistica.getMax()
    );

    return dto;
  }
}
