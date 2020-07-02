package br.com.branquinho.jpa.venda.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.branquinho.jpa.venda.model.Venda;

@Repository
public class VendaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Venda venda) {
        entityManager.persist(venda);
    }

}
