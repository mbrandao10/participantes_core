package com.matheus.enums;

public enum Civil {
    SOLTEIRO("solteiro"), CASADO("casado"), DIVORCIADO("divorciado"), VIUVO("viuvo") ;
    
    private String value;

    private Civil(String value) {
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
