package com.easygest.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easygest.springboot.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{


}
