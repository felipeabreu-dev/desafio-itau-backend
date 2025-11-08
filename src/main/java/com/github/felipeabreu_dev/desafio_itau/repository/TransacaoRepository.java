package com.github.felipeabreu_dev.desafio_itau.repository;

import com.github.felipeabreu_dev.desafio_itau.model.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    private List<Transacao> transacoes = new ArrayList<>();


    public void salvar(Transacao transacao) {
        this.transacoes.add(transacao);
    }

    public void deleteAll() {
        this.transacoes.clear();
    }

    public List<Transacao> obterTransacoes() {
        return this.transacoes;
    }

}
