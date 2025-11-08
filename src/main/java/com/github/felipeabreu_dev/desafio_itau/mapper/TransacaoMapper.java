package com.github.felipeabreu_dev.desafio_itau.mapper;

import com.github.felipeabreu_dev.desafio_itau.dto.TransacaoDTO;
import com.github.felipeabreu_dev.desafio_itau.model.Transacao;
import org.springframework.stereotype.Component;

@Component
public class TransacaoMapper {

    public Transacao paraEntidade(TransacaoDTO dto) {
        Transacao transacao = new Transacao();
        transacao.setValor(dto.valor());
        transacao.setDataHora(dto.dataHora());

        return transacao;
    }

}
