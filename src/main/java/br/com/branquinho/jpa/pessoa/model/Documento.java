package br.com.branquinho.jpa.pessoa.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Documento {

    @Id
    private String numero;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    private LocalDate dataEmissao;

}
