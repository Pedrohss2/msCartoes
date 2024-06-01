package io.github.pedrohss2.mascartoes.repository;

import io.github.pedrohss2.mascartoes.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM cartao AS c WHERE c.renda <= :renda")
    List<Cartao> findByRenda(BigDecimal renda);
}
