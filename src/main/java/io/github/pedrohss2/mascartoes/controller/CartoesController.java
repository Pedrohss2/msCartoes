package io.github.pedrohss2.mascartoes.controller;

import io.github.pedrohss2.mascartoes.dto.CartaoClienteDTO;
import io.github.pedrohss2.mascartoes.dto.CartaoDTO;
import io.github.pedrohss2.mascartoes.model.Cartao;
import io.github.pedrohss2.mascartoes.service.CartaoClienteService;
import io.github.pedrohss2.mascartoes.service.CartaoService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Procurar um cartao por renda")
    public ResponseEntity<List<CartaoDTO>> procurarPorRenda(@RequestParam(value = "renda", defaultValue = "") Long renda) {
        List<CartaoDTO> cartaoDTO = cartaoService.procurarCartaoPorRenda(renda);

        return ResponseEntity.ok().body(cartaoDTO);
    }

    @GetMapping(params = "cpf")
    @Operation(summary = "Procurar um cartao por cpf")
    public ResponseEntity<List<CartaoClienteDTO>> procurarPorCpf(@RequestParam(name = "cpf", defaultValue = "") String cpf) {
        List<CartaoClienteDTO> cartaoClienteDTOS = clienteService.procurarCartaoPorCpf(cpf);

        return ResponseEntity.ok().body(cartaoClienteDTOS);
    }

    @PostMapping
    @Operation(summary = "Criar um cartao")
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
    @Operation(summary = "Atualizar um cartao")
    public ResponseEntity<CartaoDTO> atualizar(@Valid @RequestBody CartaoDTO cartaoDTO) {
        cartaoDTO = cartaoService.atualizar(cartaoDTO);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um cartao pelo id")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cartaoService.deletar(id);

        return ResponseEntity.noContent().build();
    }

}
