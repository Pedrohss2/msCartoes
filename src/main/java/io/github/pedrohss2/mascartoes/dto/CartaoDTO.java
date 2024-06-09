package io.github.pedrohss2.mascartoes.dto;

import io.github.pedrohss2.mascartoes.model.enums.Bandeira;
import io.github.pedrohss2.mascartoes.model.Cartao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDTO {

    private Long id;
    @NotBlank(message = "Campo 'nome' não pode ser vazio")
    private String nome;
    @NotBlank(message = "Campo 'bandeira' não pode ser vazio")
    private Bandeira bandeira;
    @Min(value = 100, message = "Renda pecisa ser no minimo 100 reais")
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
