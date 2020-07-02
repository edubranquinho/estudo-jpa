package br.com.branquinho.jpa.produto.casosDeUso.cadastro.dtos;

import java.math.BigDecimal;

import br.com.branquinho.jpa.produto.model.Produto;
import lombok.Getter;

@Getter
public class ProdutoTO {

    private long codigo;
    private String descricao;
    private BigDecimal preco;

    public ProdutoTO(Produto produto) {
        codigo = produto.getCodigo();
        descricao = produto.getDescricao();
        preco = produto.getPreco();
    }
}
