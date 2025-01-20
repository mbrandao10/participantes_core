package com.manduri.exception;

import java.io.Serial;

public class RecordNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(Long idFormEscritorio) {
        super("Registro não encontrado com o idFormEscritorio: " + idFormEscritorio);
    }
}
