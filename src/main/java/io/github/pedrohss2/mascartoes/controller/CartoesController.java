package io.github.pedrohss2.mascartoes.controller;

import io.github.pedrohss2.mascartoes.dto.CartaoDTO;
import io.github.pedrohss2.mascartoes.model.Cartao;
import io.github.pedrohss2.mascartoes.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("cartoes")
public class CartoesController {

    @Autowired
    private CartaoService cartaoService;

    @GetMapping
    public ResponseEntity<List<CartaoDTO>> procurarPorRenda(@RequestParam(value = "renda", defaultValue = "") Long renda) {
        List<CartaoDTO> cartaoDTO = cartaoService.procurarCartaoPorRenda(renda);

        return ResponseEntity.ok().body(cartaoDTO);
    }

    @PostMapping
    public ResponseEntity<CartaoDTO> criar(@RequestBody CartaoDTO cartaoDTO) {
        cartaoDTO = cartaoService.criar(cartaoDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("renda={renda}")
                .buildAndExpand(cartaoDTO.getRenda()).
                toUri();

        return ResponseEntity.created(uri).build();
    }
}
