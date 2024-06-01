package io.github.pedrohss2.mascartoes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cartoes")
public class CartoesController {

    @GetMapping
    public String status() {
        return "OK!";
    }

}
