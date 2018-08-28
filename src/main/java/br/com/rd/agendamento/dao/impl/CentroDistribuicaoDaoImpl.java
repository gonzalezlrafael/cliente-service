package br.com.rd.agendamento.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.rd.agendamento.dao.CentroDistribuicaoDao;
import br.com.rd.agendamento.entity.TbCdRegional;

/**
 * A anotacao @{@link Repository} marca essa classe como repositorio e classe de pesistencia
 */
@Repository
public class CentroDistribuicaoDaoImpl implements CentroDistribuicaoDao {

    /**
     * Spring injeta instancia de entity manager
     */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TbCdRegional> findAll() {
        return entityManager.createNamedQuery("findAllCentroDistribuicao", TbCdRegional.class).getResultList();
    }
}
