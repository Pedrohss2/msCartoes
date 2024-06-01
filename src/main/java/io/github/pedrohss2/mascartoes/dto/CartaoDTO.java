package io.github.pedrohss2.mascartoes.dto;

import io.github.pedrohss2.mascartoes.enums.Bandeira;
import io.github.pedrohss2.mascartoes.model.Cartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDTO {

    private Long id;
    private String nome;
    private Bandeira bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;


    public CartaoDTO(Cartao cartao) {
        this.id = cartao.getId();
        this.nome = cartao.getNome();
        this.bandeira = cartao.getBandeira();
        this.renda = cartao.getRenda();
        this.limiteBasico = cartao.getLimiteBasico();
    }
}
