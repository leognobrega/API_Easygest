package com.easygest.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easygest.springboot.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{


}
