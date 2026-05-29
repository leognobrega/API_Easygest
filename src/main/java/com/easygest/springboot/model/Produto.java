package com.easygest.springboot.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codProduto;
    private String nomeProduto;
    private String tipoProduto;
    private Float pesoProduto;
    private Float custoProduto;
    private Float precoProduto;
    private String statusProduto;
    private LocalDate dataCompraProduto; 
    private LocalDate dataValidadeProduto; 
    private LocalDate dataVendaProduto;
    private LocalDate dataFabricacaoProduto;  

    //falta colocar a estrangeira ESTOQUE
}