package com.easygest.springboot.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygest.springboot.model.Produto;
import com.easygest.springboot.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
   private ProdutoRepository produtoRepository;

   public List<Produto> listarTodos(){
        return produtoRepository.findAll();
   }

   public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
   }

   public Produto buscarPorCod(Long codProduto){
    return produtoRepository.findById(codProduto).orElse(null);
   }

   public Produto atualizar(Long codProduto, Produto novo){
    Produto existente = buscarPorCod(codProduto);

    existente.setNomeProduto(novo.getNomeProduto());
    existente.setTipoProduto(novo.getTipoProduto());
    existente.setPesoProduto(novo.getPesoProduto());
    existente.setCustoProduto(novo.getCustoProduto());
    existente.setPrecoProduto(novo.getPrecoProduto());
    existente.setStatusProduto(novo.getStatusProduto());
    existente.setDataCompraProduto(novo.getDataCompraProduto());
    existente.setDataValidadeProduto(novo.getDataValidadeProduto());
    existente.setDataVendaProduto(novo.getDataVendaProduto());
    existente.setDataFabricacaoProduto(novo.getDataFabricacaoProduto());

    return produtoRepository.save(existente);
   }
    
   public void excluir(Long codProduto){
    produtoRepository.deleteById(codProduto);
   }
}

