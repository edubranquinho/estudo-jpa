package br.com.branquinho.jpa.produto.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.branquinho.jpa.produto.model.Categoria;
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

    public List<Produto> listarProdutos() {
        String jpql = "select p from Produto p order by p.preco desc ";

        final TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        return query.getResultList();
    }

    public List<Produto> listarProdutos(Categoria categoria) {
        StringBuilder sql = new StringBuilder("select p from Produto p join p.categorias  c ");
        sql.append(" where c = :categoria ");

        final TypedQuery<Produto> query = entityManager.createQuery(sql.toString(), Produto.class);
        query.setParameter("categoria", categoria);


        return query.getResultList();
    }
}
