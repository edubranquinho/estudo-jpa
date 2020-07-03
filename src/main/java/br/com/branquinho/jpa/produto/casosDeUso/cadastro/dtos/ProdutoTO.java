package br.com.branquinho.jpa.produto.casosDeUso.cadastro.dtos;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.branquinho.jpa.produto.model.Categoria;
import br.com.branquinho.jpa.produto.model.Produto;
import lombok.Getter;

@Getter
public class ProdutoTO {

    private long codigo;
    private String descricao;
    private BigDecimal preco;
    private List<String> categorias;

    public ProdutoTO(Produto produto) {
        codigo = produto.getCodigo();
        descricao = produto.getDescricao();
        preco = produto.getPreco();
        categorias = produto.getCategorias().stream().map(Categoria::getNome).collect(Collectors.toList());
    }
}
