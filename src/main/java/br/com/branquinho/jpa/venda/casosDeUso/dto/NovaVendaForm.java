package br.com.branquinho.jpa.venda.casosDeUso.dto;

import br.com.branquinho.jpa.venda.model.FormaPagamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovaVendaForm {

    private long produtoKey;
    private FormaPagamento formaPagamento;

}
