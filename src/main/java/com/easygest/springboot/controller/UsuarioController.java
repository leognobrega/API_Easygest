package com.easygest.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.easygest.springboot.model.Usuario;
import com.easygest.springboot.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @GetMapping("/{codUsuario}")
    public Usuario buscarPorId(
            @PathVariable Long codUsuario) {

        return service.buscarPorId(codUsuario);
    }

    @PostMapping
    public Usuario salvar(
            @RequestBody Usuario usuario) {

        return service.salvar(usuario);
    }

    @PutMapping("/{codUsuario}")
    public Usuario atualizar(
            @PathVariable Long codUsuario,
            @RequestBody Usuario usuario) {

        return service.atualizar(
                codUsuario,
                usuario);
    }

    @DeleteMapping("/{codUsuario}")
    public void deletar(
            @PathVariable Long codUsuario) {

        service.deletar(codUsuario);
    }
}
