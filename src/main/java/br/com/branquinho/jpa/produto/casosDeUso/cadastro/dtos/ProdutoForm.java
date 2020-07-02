package br.com.branquinho.jpa.produto.casosDeUso.cadastro.dtos;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.branquinho.jpa.produto.model.Produto;
import lombok.Getter;
import lombok.Setter;

import static java.math.BigDecimal.valueOf;

@Getter
@Setter
public class ProdutoForm {

    @NotBlank(message = "Por favor informe a descrição do produto")
    private String descricao;
    @DecimalMin(value = "0.01", message = "O preço mínimo é 0.01")
    @NotNull(message = "Por favor informe o preço do produto")
    private Double preco;

    public Produto toEntity() {
        return new Produto(descricao, valueOf(preco));
    }
}
