package br.com.branquinho.jpa.venda.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.branquinho.jpa.produto.model.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    private LocalDateTime data = LocalDateTime.now();
    
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
}
