package com.github.felipeabreu_dev.desafio_itau.service;

import com.github.felipeabreu_dev.desafio_itau.dto.TransacaoDTO;
import com.github.felipeabreu_dev.desafio_itau.mapper.TransacaoMapper;
import com.github.felipeabreu_dev.desafio_itau.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private TransacaoRepository transacaoRepository;
    private TransacaoMapper mapper;

    public void salvarTransacao(TransacaoDTO dto) {
        transacaoRepository.salvar(mapper.paraEntidade(dto));
    }

}
