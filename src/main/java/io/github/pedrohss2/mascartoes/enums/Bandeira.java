package io.github.pedrohss2.mascartoes.enums;

import lombok.Getter;

@Getter
public enum Bandeira {

    MASTER_CARD("master_card"),
    VISA("visa");

    public String bandeira;

    Bandeira(String bandeira) {
        this.bandeira = bandeira;
    }

}
