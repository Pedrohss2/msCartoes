package io.github.pedrohss2.mascartoes.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DadosEmissaoCartao {

    private Long id;
    private String cpf;
    private String endereco;
    private BigDecimal limiteLiberado;

}
