package br.com.branquinho.jpa.produto.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Categoria {

    @Id
    private String nome;

    @Deprecated //somente para uso de Framework
    public Categoria() {}

    public Categoria(String descricao) {
        nome = descricao;
    }

}
