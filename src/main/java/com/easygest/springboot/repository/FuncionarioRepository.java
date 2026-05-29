package com.easygest.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easygest.springboot.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{


}
