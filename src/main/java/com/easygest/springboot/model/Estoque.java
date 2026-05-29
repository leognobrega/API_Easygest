package com.easygest.springboot.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long codEstoque;
    private BigDecimal quantidadeEstoque;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    
   @ManyToOne
    @JoinColumn(name = "codProduto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "codFornecedor")
    private Fornecedor fornecedor;
}
