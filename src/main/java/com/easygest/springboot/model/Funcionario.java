package com.easygest.springboot.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codFuncionario;
    private String nomeFuncionario;
    private String cpfFuncionario;
    private String ctpsFuncionario;
    private String cargoFuncionario;
    private BigDecimal salarioFuncionario;
    private LocalDate dataAdmissaoFuncionario;
    private LocalDate dataDemissaoFuncionario;
    @OneToOne
    @JoinColumn(name = "codUsuario")
    private Usuario usuario;

}


