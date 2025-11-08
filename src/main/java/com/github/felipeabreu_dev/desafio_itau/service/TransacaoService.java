package com.github.felipeabreu_dev.desafio_itau.service;

import com.github.felipeabreu_dev.desafio_itau.dto.TransacaoDTO;
import com.github.felipeabreu_dev.desafio_itau.mapper.TransacaoMapper;
import com.github.felipeabreu_dev.desafio_itau.model.Transacao;
import com.github.felipeabreu_dev.desafio_itau.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final TransacaoMapper mapper;

    public void salvarTransacao(TransacaoDTO dto) {
        Transacao transacao = mapper.paraEntidade(dto);
        validar(transacao);
        transacaoRepository.salvar(transacao);
    }

    public void deletarTransacoes() {
        transacaoRepository.deleteAll();
    }

    List<Transacao> transacoesNosUltimos60Segundos() {
        return transacaoRepository.obterTransacoes()
                .stream()
                .filter(transacao -> transacao.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(60)))
                .toList();
    }

    void validar(Transacao transacao) {
        if(valorTransacaoEMenorQueZero(transacao)) {
            throw new IllegalArgumentException();
        }
    }

    boolean valorTransacaoEMenorQueZero(Transacao transacao) {
        return transacao.getValor() < 0;
    }

}
