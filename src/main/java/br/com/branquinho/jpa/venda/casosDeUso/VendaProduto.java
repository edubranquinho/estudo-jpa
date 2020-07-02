package br.com.branquinho.jpa.venda.casosDeUso;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import br.com.branquinho.jpa.produto.model.Produto;
import br.com.branquinho.jpa.produto.repository.ProdutoRepository;
import br.com.branquinho.jpa.venda.casosDeUso.dto.NovaVendaForm;
import br.com.branquinho.jpa.venda.model.Venda;
import br.com.branquinho.jpa.venda.repository.VendaRepository;

@Service
public class VendaProduto {

    private final ProdutoRepository produtoRepository;
    private final VendaRepository vendaRepository;

    public VendaProduto(ProdutoRepository produtoRepository, VendaRepository vendaRepository) {
        this.produtoRepository = produtoRepository;
        this.vendaRepository = vendaRepository;
    }

    @Transactional(rollbackOn = Exception.class)
    public Venda criarVenda(NovaVendaForm form) {
        final Produto produto = produtoRepository.findById(form.getProdutoKey())
            .orElseThrow(() -> new RuntimeException("Produto " + form.getProdutoKey() + " não encontrado"));

        final Venda venda = Venda
            .builder()
            .formaPagamento(form.getFormaPagamento())
            .produto(produto)
            .valor(produto.getPreco())
            .data(LocalDateTime.now())
            .build();

        vendaRepository.save(venda);
        return venda;
    }

}
