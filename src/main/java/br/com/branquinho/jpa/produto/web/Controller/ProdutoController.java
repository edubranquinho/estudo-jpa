package br.com.branquinho.jpa.produto.web.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import br.com.branquinho.jpa.produto.casosDeUso.cadastro.NovoProduto;
import br.com.branquinho.jpa.produto.casosDeUso.cadastro.dtos.ProdutoForm;
import br.com.branquinho.jpa.produto.casosDeUso.cadastro.dtos.ProdutoTO;
import br.com.branquinho.jpa.produto.model.Produto;
import br.com.branquinho.jpa.produto.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final NovoProduto novoProduto;
    private final ProdutoRepository produtoRepository;

    public ProdutoController(NovoProduto novoProduto, ProdutoRepository produtoRepository) {
        this.novoProduto = novoProduto;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoTO novoProduto(@RequestBody @Valid ProdutoForm formularioProduto) {
        final Produto produto = novoProduto.cadastrarProduto(formularioProduto);
        return new ProdutoTO(produto);
    }

    @GetMapping
    public List<ProdutoTO> listarProdutos() {
        final List<Produto> produtos = produtoRepository.listarProdutos();
        return produtos
            .stream()
            .map(ProdutoTO::new)
            .collect(Collectors.toList());
    }
}
