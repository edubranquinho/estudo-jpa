package br.com.branquinho.jpa.produto.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @NotNull
    private String descricao;
    private BigDecimal preco;

    @Deprecated //Somente para uso de Frameworks
    public Produto() {}

    public Produto(String descricao, BigDecimal preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

}