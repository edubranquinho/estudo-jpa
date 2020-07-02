package br.com.branquinho.jpa.venda.casosDeUso.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.branquinho.jpa.venda.model.FormaPagamento;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class VendaView {

    private Long id;
    private String descricaoProduto;
    private BigDecimal valor;
    private LocalDateTime data;
    private FormaPagamento formaPagamento;

}
