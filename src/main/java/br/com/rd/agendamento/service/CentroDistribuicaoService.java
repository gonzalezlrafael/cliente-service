package br.com.rd.agendamento.service;

import java.util.List;

import br.com.rd.agendamento.entity.TbCdRegional;

public interface CentroDistribuicaoService {

    List<TbCdRegional> findAll();

}
