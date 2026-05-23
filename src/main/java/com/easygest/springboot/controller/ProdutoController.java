package com.easygest.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easygest.springboot.model.Produto;
import com.easygest.springboot.service.ProdutoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listar(){
        return produtoService.listarTodos();
    }

    @PostMapping
    public Produto criar (@RequestBody Produto produto){
        return produtoService.salvar(produto);
    }

    public Produto atualizar(@RequestBody Produto produto, @PathVariable Long codProduto){
        return produtoService.atualizar(codProduto, produto);
    }

    @DeleteMapping("/{codProduto}")
public void excluir(@PathVariable Long codProduto) {
    produtoService.excluir(codProduto);
}
}
