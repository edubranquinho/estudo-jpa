package br.com.branquinho.jpa.produto.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.branquinho.jpa.produto.model.Produto;

@Repository
public class ProdutoRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Produto produto) {
        entityManager.persist(produto);
    }

    public Optional<Produto> findById(Long codigo) {
        return Optional.ofNullable(entityManager.find(Produto.class, codigo));
    }
}
