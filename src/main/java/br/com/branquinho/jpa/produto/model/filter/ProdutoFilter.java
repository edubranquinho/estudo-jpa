package br.com.branquinho.jpa.produto.model.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoFilter {

    private Long codigo;
    private String descricao;
    private String categoria;

}
