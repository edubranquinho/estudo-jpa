package br.com.branquinho.jpa.produto.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

    //exemplo de jpql
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

    //examplo de criteria
    public List<Produto> listarProdutosPorCriteria(ProdutoFilter filtro) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Produto> query = criteriaBuilder.createQuery(Produto.class);

        final Root<Produto> root = query.from(Produto.class);
        final Path<String> descricao = root.get("descricao");
        final Path<String> codigo = root.get("codigo");
        final Path<String> categoria = root.join("categorias").<String>get("nome");

        final Predicate predicateDescricao = criteriaBuilder.like(descricao, filtro.getDescricao());
        final Predicate predicateCategoria = criteriaBuilder.equal(categoria, filtro.getCategoria());
        final Predicate predicateCodigo = criteriaBuilder.equal(codigo, filtro.getCodigo());

        query.where(predicateDescricao, predicateCategoria, predicateCodigo);

        final TypedQuery<Produto> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
