package com.easygest.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygest.springboot.model.Prestadores;
import com.easygest.springboot.repository.PrestadoresRepository;

@Service
public class PrestadoresService {

    @Autowired
    private PrestadoresRepository repository;

    // LISTAR
    public List<Prestadores> listar() {

        return repository.findAll();
    }

    // SALVAR
    public Prestadores salvar(Prestadores prestador) {

        return repository.save(prestador);
    }

    // BUSCAR POR ID
    public Prestadores buscarPorId(Long codPrestador) {

        return repository.findById(codPrestador)
                .orElseThrow();
    }

    // ATUALIZAR
    public Prestadores atualizar(
            Long codPrestador,
            Prestadores prestador) {

        Prestadores prestadorExistente =
                buscarPorId(codPrestador);

        prestadorExistente.setRazaoSocialPrestador(
                prestador.getRazaoSocialPrestador());

        prestadorExistente.setNomePrestador(
                prestador.getNomePrestador());

        prestadorExistente.setCnpjPrestador(
                prestador.getCnpjPrestador());

        prestadorExistente.setCpfPrestador(
                prestador.getCpfPrestador());

        prestadorExistente.setEnderecoPrestador(
                prestador.getEnderecoPrestador());

        prestadorExistente.setTelefonePrestador(
                prestador.getTelefonePrestador());

        prestadorExistente.setEmailPrestador(
                prestador.getEmailPrestador());

        prestadorExistente.setDataServicoPrestador(
                prestador.getDataServicoPrestador());

        prestadorExistente.setDataPagamentoPrestador(
                prestador.getDataPagamentoPrestador());

        prestadorExistente.setValorPrestador(
                prestador.getValorPrestador());

        return repository.save(prestadorExistente);
    }

    // DELETAR
    public void deletar(Long codPrestador) {

        repository.deleteById(codPrestador);
    }
}