package io.github.pedrohss2.mascartoes.service;

import io.github.pedrohss2.mascartoes.dto.CartaoDTO;
import io.github.pedrohss2.mascartoes.model.Cartao;
import io.github.pedrohss2.mascartoes.repository.CartaoRepository;
import io.github.pedrohss2.mascartoes.service.exception.CartaoNaoEncontradoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CartaoDTO> procurarCartaoPorRenda(Long renda) {

        try {
            var rendaBigdecimal = BigDecimal.valueOf(renda);

            List<Cartao> cartao = cartaoRepository.findByRenda(rendaBigdecimal);

            return cartao.stream().map(CartaoDTO::new).toList();
        }
        catch (EntityNotFoundException erro) {
                throw new CartaoNaoEncontradoException("Cartao não encontrado");
        }
    }

    @Transactional
    public CartaoDTO criar(CartaoDTO cartaoDTO) {
        Cartao cartao = modelMapper.map(cartaoDTO, Cartao.class);

        cartao = cartaoRepository.save(cartao);

        return modelMapper.map(cartao, CartaoDTO.class);
    }

    public CartaoDTO atualizar(CartaoDTO cartaoDTO) {
        try {
            Cartao cartao = modelMapper.map(cartaoDTO, Cartao.class);

            cartao = cartaoRepository.save(cartao);

            return modelMapper.map(cartao, CartaoDTO.class);
        }
        catch (EntityNotFoundException erro) {
            throw new CartaoNaoEncontradoException("Cartao não encontrado");
        }
    }

    public void deletar(Long id) {
        cartaoRepository.findById(id).orElseThrow(() -> new CartaoNaoEncontradoException("Cartao não encontrado!!"));

        try {
            cartaoRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException erro) {
            throw new CartaoNaoEncontradoException(erro.getMessage());
        }
    }



}
