package com.easygest.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easygest.springboot.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{


}
