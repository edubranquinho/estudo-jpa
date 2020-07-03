package br.com.branquinho.jpa.produto.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.branquinho.jpa.produto.model.Produto;
import br.com.branquinho.jpa.produto.model.filter.ProdutoFilter;

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

    public List<Produto> listarProdutos(ProdutoFilter filtro) {
        StringBuilder jpql = new StringBuilder("select p from Produto p ");

        if (filtro.getCategoria() != null) {
            jpql.append(" join fetch p.categorias c ");
            jpql.append(" where lower(c.nome) like :pNome ");
        }

        jpql.append("order by p.preco desc ");

        final TypedQuery<Produto> query = entityManager.createQuery(jpql.toString(), Produto.class);

        if (filtro.getCategoria() != null) {
            query.setParameter("pNome", "%" + filtro.getCategoria().toLowerCase() + "%");
        }

        return query.getResultList();
    }
}
