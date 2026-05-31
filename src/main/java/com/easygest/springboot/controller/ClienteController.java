package com.easygest.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.easygest.springboot.model.Cliente;
import com.easygest.springboot.service.ClienteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @GetMapping("/{codCliente}")
    public Cliente buscarPorId(@PathVariable Long codCliente) {
        return service.buscarPorId(codCliente);
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }

    @PutMapping("/{codCliente}")
    public Cliente atualizar(
            @PathVariable Long codCliente,
            @RequestBody Cliente cliente) {

        return service.atualizar(codCliente, cliente);
    }

    @DeleteMapping("/{codCliente}")
    public void deletar(@PathVariable Long codCliente) {
        service.deletar(codCliente);
    }
}
