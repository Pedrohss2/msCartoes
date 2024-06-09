package io.github.pedrohss2.mascartoes.dto;

import io.github.pedrohss2.mascartoes.model.CartaoCliente;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CartaoClienteDTO {

    private Long id;
    private String cpf;
    private BigDecimal limiteAprovado;

    public CartaoClienteDTO(CartaoCliente cliente) {
        this.id = cliente.getId();
        this.cpf = cliente.getCpf();
        this.limiteAprovado = cliente.getLimiteAprovado();
    }
}
