package com.easygest.springboot.model;


import java.math.BigDecimal;
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
public class Prestadores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codPrestador;
    private String razaoSocialPrestador;
    private String nomePrestador;
    private String cnpjPrestador;
    private String cpfPrestador;
    private String enderecoPrestador;
    private String telefonePrestador;
    private String emailPrestador;
    private LocalDate dataServicoPrestador;
    private LocalDate dataPagamentoPrestador;
    private BigDecimal valorPrestador;
}
