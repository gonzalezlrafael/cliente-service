package br.com.rd.agendamento.dao;

import java.util.List;

import br.com.rd.agendamento.entity.TbCdRegional;

/**
 * Persistencia no banco de dados para entidade curso
 */
public interface CentroDistribuicaoDao {

    List<TbCdRegional> findAll();
}
