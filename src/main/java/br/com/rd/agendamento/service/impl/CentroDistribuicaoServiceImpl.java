package br.com.rd.agendamento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rd.agendamento.dao.CentroDistribuicaoDao;
import br.com.rd.agendamento.entity.TbCdRegional;
import br.com.rd.agendamento.service.CentroDistribuicaoService;

/**
 * A anotação @{@link Service} marca a classe como um bean gerenciado pelo spring (Bena de negocio)
 * A anotação @{@link Transactional} vai informar para o spring que deve gerenciar as transacoes dos metodos que estao nessa classe
 * essa anotação contem um parametro read-only setado como false, assim sendo a transação será tanto para leitura como para escrita
 */
@Service
@Transactional
public class CentroDistribuicaoServiceImpl implements CentroDistribuicaoService {

    @Autowired
    private CentroDistribuicaoDao dao;


    @Override
    @Transactional(readOnly = true)
    public List<TbCdRegional> findAll() {
        return dao.findAll();
    }


}
