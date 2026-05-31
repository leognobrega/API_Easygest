package com.easygest.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.easygest.springboot.model.Fornecedor;
import com.easygest.springboot.service.FornecedorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public List<Fornecedor> listar() {
        return service.listar();
    }

    @GetMapping("/{codFornecedor}")
    public Fornecedor buscarPorId(
            @PathVariable Long codFornecedor) {

        return service.buscarPorId(codFornecedor);
    }

    @PostMapping
    public Fornecedor salvar(
            @RequestBody Fornecedor fornecedor) {

        return service.salvar(fornecedor);
    }

    @PutMapping("/{codFornecedor}")
    public Fornecedor atualizar(
            @PathVariable Long codFornecedor,
            @RequestBody Fornecedor fornecedor) {

        return service.atualizar(
                codFornecedor,
                fornecedor);
    }

    @DeleteMapping("/{codFornecedor}")
    public void deletar(
            @PathVariable Long codFornecedor) {

        service.deletar(codFornecedor);
    }
}