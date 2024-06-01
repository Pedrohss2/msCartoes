package io.github.pedrohss2.mascartoes.model;

import io.github.pedrohss2.mascartoes.enums.Bandeira;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cartao")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "bandeira", nullable = false)
    private Bandeira bandeira;

    @Column(name = "renda", nullable = false)
    private BigDecimal renda;

    @Column(name = "limite_basico", nullable = false)
    private BigDecimal limiteBasico;

    public Cartao(Long id, String nome, Bandeira bandeira, BigDecimal renda, BigDecimal limiteBasico) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.renda = renda;
        this.limiteBasico = limiteBasico;
    }

}
