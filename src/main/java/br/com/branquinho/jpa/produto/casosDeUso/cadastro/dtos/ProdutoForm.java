package br.com.branquinho.jpa.produto.casosDeUso.cadastro.dtos;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.branquinho.jpa.produto.model.Categoria;
import br.com.branquinho.jpa.produto.model.Produto;
import lombok.Getter;
import lombok.Setter;

import static java.math.BigDecimal.valueOf;

@Getter
@Setter
public class ProdutoForm {

    @NotBlank
    private String descricao;
    @DecimalMin(value = "0.01")
    @NotNull
    private Double preco;
    private List<String> categorias;

    public Produto toEntity() {
        Produto produto = new Produto(descricao, valueOf(preco));
        produto.setCategorias(categorias.stream().map(Categoria::new).collect(Collectors.toList()));
        return produto;
    }
}
