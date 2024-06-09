package io.github.pedrohss2.mascartoes.controller;

import io.github.pedrohss2.mascartoes.dto.CartaoClienteDTO;
import io.github.pedrohss2.mascartoes.dto.CartaoDTO;
import io.github.pedrohss2.mascartoes.model.Cartao;
import io.github.pedrohss2.mascartoes.service.CartaoClienteService;
import io.github.pedrohss2.mascartoes.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("cartoes")
public class CartoesController {

    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private CartaoClienteService clienteService;

    @GetMapping(params = "renda")
    public ResponseEntity<List<CartaoDTO>> procurarPorRenda(@RequestParam(value = "renda", defaultValue = "") Long renda) {
        List<CartaoDTO> cartaoDTO = cartaoService.procurarCartaoPorRenda(renda);

        return ResponseEntity.ok().body(cartaoDTO);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartaoClienteDTO>> procurarPorCpf(@RequestParam(name = "cpf", defaultValue = "") String cpf) {
        List<CartaoClienteDTO> cartaoClienteDTOS = clienteService.procurarCartaoPorCpf(cpf);

        return ResponseEntity.ok().body(cartaoClienteDTOS);
    }

    @PostMapping
    public ResponseEntity<CartaoDTO> criar(@Valid @RequestBody CartaoDTO cartaoDTO) {
        cartaoDTO = cartaoService.criar(cartaoDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("renda={renda}")
                .buildAndExpand(cartaoDTO.getRenda()).
                toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<CartaoDTO> atualizar(@Valid @RequestBody CartaoDTO cartaoDTO) {
        cartaoDTO = cartaoService.atualizar(cartaoDTO);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cartaoService.deletar(id);

        return ResponseEntity.noContent().build();
    }

}
