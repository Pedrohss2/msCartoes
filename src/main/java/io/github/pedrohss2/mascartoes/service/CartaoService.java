package io.github.pedrohss2.mascartoes.service;

import io.github.pedrohss2.mascartoes.dto.CartaoDTO;
import io.github.pedrohss2.mascartoes.model.Cartao;
import io.github.pedrohss2.mascartoes.repository.CartaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public CartaoDTO criar(CartaoDTO cartaoDTO) {
        Cartao cartao = modelMapper.map(cartaoDTO, Cartao.class);

        cartao = cartaoRepository.save(cartao);

        return modelMapper.map(cartao, CartaoDTO.class);
    }

    public List<CartaoDTO> procurarCartaoPorRenda(Long renda) {
        var rendaBigdecimal = BigDecimal.valueOf(renda);

        List<Cartao> cartao = cartaoRepository.findByRenda(rendaBigdecimal);

        return cartao.stream().map(CartaoDTO::new).toList();
    }
}
