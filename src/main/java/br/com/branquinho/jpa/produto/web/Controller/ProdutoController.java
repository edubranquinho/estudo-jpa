package br.com.branquinho.jpa.produto.web.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import br.com.branquinho.jpa.produto.casosDeUso.cadastro.NovoProduto;
import br.com.branquinho.jpa.produto.casosDeUso.cadastro.dtos.ProdutoForm;
import br.com.branquinho.jpa.produto.casosDeUso.cadastro.dtos.ProdutoTO;
import br.com.branquinho.jpa.produto.model.Produto;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final NovoProduto novoProduto;

    public ProdutoController(NovoProduto novoProduto) {
        this.novoProduto = novoProduto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoTO novoProduto(@RequestBody @Valid ProdutoForm formularioProduto) {
        final Produto produto = novoProduto.cadastrarProduto(formularioProduto);
        return new ProdutoTO(produto);
    }
}
