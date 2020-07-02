package br.com.branquinho.jpa.produto.casosDeUso.cadastro;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import br.com.branquinho.jpa.produto.casosDeUso.cadastro.dtos.ProdutoForm;
import br.com.branquinho.jpa.produto.model.Produto;
import br.com.branquinho.jpa.produto.repository.ProdutoRepository;

@Service
public class NovoProduto {

    private final ProdutoRepository produtoRepository;

    public NovoProduto(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional(rollbackOn = Exception.class)
    public Produto cadastrarProduto(ProdutoForm produtoForm) {
        final Produto produto = produtoForm.toEntity();
        produtoRepository.save(produto);
        return produto;
    }
}
