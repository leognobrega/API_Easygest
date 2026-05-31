package com.easygest.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygest.springboot.model.Usuario;
import com.easygest.springboot.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // LISTAR
    public List<Usuario> listar() {
        return repository.findAll();
    }

    // SALVAR
    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    // BUSCAR POR ID
    public Usuario buscarPorId(Long codUsuario) {
        return repository.findById(codUsuario)
                .orElseThrow();
    }

    // ATUALIZAR
    public Usuario atualizar(Long codUsuario, Usuario usuario) {

        Usuario usuarioExistente =
                buscarPorId(codUsuario);

        usuarioExistente.setTipoUsuario(
                usuario.getTipoUsuario());

        return repository.save(usuarioExistente);
    }

    // DELETAR
    public void deletar(Long codUsuario) {
        repository.deleteById(codUsuario);
    }
}