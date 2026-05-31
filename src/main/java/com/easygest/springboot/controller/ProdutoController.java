package com.easygest.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.easygest.springboot.model.Produto;
import com.easygest.springboot.service.ProdutoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{codProduto}")
    public Produto buscarPorCodigo(
            @PathVariable Long codProduto) {

        return produtoService.buscarPorCod(codProduto);
    }

    @PostMapping
    public Produto criar(
            @RequestBody Produto produto) {

        return produtoService.salvar(produto);
    }

    @PutMapping("/{codProduto}")
    public Produto atualizar(
            @PathVariable Long codProduto,
            @RequestBody Produto produto) {

        return produtoService.atualizar(
                codProduto,
                produto);
    }

    @DeleteMapping("/{codProduto}")
    public void excluir(
            @PathVariable Long codProduto) {

        produtoService.excluir(codProduto);
    }
}
