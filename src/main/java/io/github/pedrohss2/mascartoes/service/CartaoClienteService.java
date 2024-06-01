package io.github.pedrohss2.mascartoes.service;

import io.github.pedrohss2.mascartoes.dto.CartaoClienteDTO;
import io.github.pedrohss2.mascartoes.repository.CartaoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoClienteService {

    @Autowired
    private CartaoClienteRepository cartaoClienteRepository;

    public List<CartaoClienteDTO> procurarCartaoPorCpf(String cpf) {
        List<CartaoClienteDTO> cartaoClienteDTOS = cartaoClienteRepository.findByCpf(cpf);

        return cartaoClienteDTOS;
    }

}
