package com.easygest.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.easygest.springboot.model.Prestadores;
import com.easygest.springboot.service.PrestadoresService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prestadores")
public class PrestadoresController {

    @Autowired
    private PrestadoresService service;

    @GetMapping
    public List<Prestadores> listar() {
        return service.listar();
    }

    @GetMapping("/{codPrestador}")
    public Prestadores buscarPorId(
            @PathVariable Long codPrestador) {

        return service.buscarPorId(codPrestador);
    }

    @PostMapping
    public Prestadores salvar(
            @RequestBody Prestadores prestador) {

        return service.salvar(prestador);
    }

    @PutMapping("/{codPrestador}")
    public Prestadores atualizar(
            @PathVariable Long codPrestador,
            @RequestBody Prestadores prestador) {

        return service.atualizar(
                codPrestador,
                prestador);
    }

    @DeleteMapping("/{codPrestador}")
    public void deletar(
            @PathVariable Long codPrestador) {

        service.deletar(codPrestador);
    }
}