package io.github.pedrohss2.mascartoes.repository;

import io.github.pedrohss2.mascartoes.dto.CartaoClienteDTO;
import io.github.pedrohss2.mascartoes.model.CartaoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoClienteRepository extends JpaRepository<CartaoCliente, Long> {

    List<CartaoClienteDTO> findByCpf(String cpf);
}
