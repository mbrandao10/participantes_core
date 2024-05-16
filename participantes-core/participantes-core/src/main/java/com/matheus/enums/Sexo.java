package com.matheus.enums;

public enum Sexo {
    MASCULINO("masculino"), FEMININO("feminino");
    
    private String value;

    private Sexo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
