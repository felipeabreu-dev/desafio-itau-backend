package com.github.felipeabreu_dev.desafio_itau.service;

import com.github.felipeabreu_dev.desafio_itau.dto.EstatisticaDTO;
import com.github.felipeabreu_dev.desafio_itau.mapper.EstatisticaMapper;
import com.github.felipeabreu_dev.desafio_itau.model.Estatistica;
import com.github.felipeabreu_dev.desafio_itau.model.Transacao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatisticaService {

    private final TransacaoService transacaoService;
    private final EstatisticaMapper mapper;

    public EstatisticaDTO obterEstatisticas() {
        Estatistica estatistica = new Estatistica();

        DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();
        valorTransacoes()
                .forEach(doubleSummaryStatistics::accept);

        estatistica.setCount(Math.toIntExact(doubleSummaryStatistics.getCount()));
        estatistica.setSum(doubleSummaryStatistics.getSum());
        estatistica.setAvg(doubleSummaryStatistics.getAverage());
        estatistica.setMin(doubleSummaryStatistics.getCount() == 0 ? 0.0 : doubleSummaryStatistics.getMin());
        estatistica.setMax(doubleSummaryStatistics.getCount() == 0 ? 0.0 : doubleSummaryStatistics.getMax());

        return mapper.paraDTO(estatistica);
    }

    List<Double> valorTransacoes() {
        return transacaoService.transacoesNosUltimos60Segundos()
                .stream()
                .map(Transacao::getValor)
                .toList();
    }

}
