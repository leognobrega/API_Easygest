package com.easygest.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygest.springboot.model.Estoque;
import com.easygest.springboot.repository.EstoqueRepository;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    // LISTAR
    public List<Estoque> listar() {

        return repository.findAll();
    }

    // SALVAR
    public Estoque salvar(Estoque estoque) {

        return repository.save(estoque);
    }

    // BUSCAR POR ID
    public Estoque buscarPorId(Long codEstoque) {

        return repository.findById(codEstoque)
                .orElseThrow();
    }

    // ATUALIZAR
    public Estoque atualizar(
            Long codEstoque,
            Estoque estoque) {

        Estoque estoqueExistente =
                buscarPorId(codEstoque);

        estoqueExistente.setQuantidadeEstoque(
                estoque.getQuantidadeEstoque());

        estoqueExistente.setDataEntrada(
                estoque.getDataEntrada());

        estoqueExistente.setDataSaida(
                estoque.getDataSaida());

        // FK PRODUTO
estoqueExistente.setProduto(
        estoque.getProduto());

// FK FORNECEDOR
estoqueExistente.setFornecedor(
        estoque.getFornecedor());

return repository.save(estoqueExistente);
    }

    // DELETAR
    public void deletar(Long codEstoque) {

        repository.deleteById(codEstoque);
    }
}
