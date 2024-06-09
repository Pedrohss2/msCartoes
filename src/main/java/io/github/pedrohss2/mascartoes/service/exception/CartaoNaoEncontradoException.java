package io.github.pedrohss2.mascartoes.service.exception;

public class CartaoNaoEncontradoException extends RuntimeException {


    public CartaoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
