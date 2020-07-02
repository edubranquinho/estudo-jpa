package br.com.branquinho.jpa.venda.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.branquinho.jpa.venda.casosDeUso.VendaProduto;
import br.com.branquinho.jpa.venda.casosDeUso.dto.NovaVendaForm;

@RestController
@RequestMapping("/api/venda")
public class VendaController {

    private final VendaProduto vendaProduto;

    public VendaController(VendaProduto vendaProduto) {
        this.vendaProduto = vendaProduto;
    }

    @PostMapping
    public void criarVenda(@RequestBody NovaVendaForm form) {
        vendaProduto.criarVenda(form);
    }

}
