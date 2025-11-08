package com.github.felipeabreu_dev.desafio_itau.service;

import com.github.felipeabreu_dev.desafio_itau.dto.TransacaoDTO;
import com.github.felipeabreu_dev.desafio_itau.mapper.TransacaoMapper;
import com.github.felipeabreu_dev.desafio_itau.model.Transacao;
import com.github.felipeabreu_dev.desafio_itau.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    void validar(Transacao transacao) {
        if(valorTransacaoEMenorQueZero(transacao)) {
            throw new IllegalArgumentException();
        }
    }

    boolean valorTransacaoEMenorQueZero(Transacao transacao) {
        return transacao.getValor() < 0;
    }

}
